package com.example.controller;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.entity.User;
import com.example.exception.CustomerException;
import com.example.service.AdminService;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class webcontroller {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;
    //表示get请求
    @GetMapping("/hello")//接口唯一
    public Result hello() {

        return Result.success("hello");
    }
    @GetMapping("/Admin")
    public Result admin(String name) {
        String adminName = adminService.admin(name);
        return Result.success(adminName);
    }
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        Account dbAccount = null;
        if ("ADMIN".equals(account.getRole())) {
            dbAccount = adminService.login(account);
        } else if ("USER".equals(account.getRole())) {
            dbAccount = userService.login(account);
        } else {
            throw new CustomerException("非法请求");
        }
        return Result.success(dbAccount);
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return Result.success();
    }
}
