package com.example.service;

import com.example.entity.Admin;
import com.example.exception.CustomerException;
import com.example.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Resource
    AdminMapper adminMapper;
    public String admin(String username) {
        if (username.equals("admin") ) {
            return "admin";
        }else {
            throw new CustomerException("账号错误");
        }
    }
    public List<Admin> selectAll(){
        return adminMapper.selectAll();
    }
}
