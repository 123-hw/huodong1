package com.example.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.exception.CustomerException;
import com.example.service.AdminService;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Resource
    AdminService adminService;
    @Resource
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         String token=request.getHeader("token");
         if(StrUtil.isEmpty(token)){

             token=request.getParameter("token");
         }
         if(StrUtil.isBlank(token)){
             throw new CustomerException("401","无权限操作");
         }
        Account account=null;
         try {


             String audience=JWT.decode(token).getAudience().get(0);
             String[] split = audience.split("-");
             String userId=split[0];
             String role=split[1];
             if("ADMIN".equals(role)){
                 account= adminService.selectById(userId);
             }else if("USER".equals(role)){
                 account=userService.selectById(userId);
             }

         }catch (Exception e){
             throw new CustomerException("401","无权限操作");
         }
        if(account==null){
            throw new CustomerException("401","无权限操作");
        }

        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(account.getPassword())).build();
            jwtVerifier.verify(token);
        }catch (Exception e){
            throw new CustomerException("401","无权限操作");
        }
        return true;
    }
}
