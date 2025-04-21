package com.example.service;

import com.example.exception.CustomerException;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public String admin(String username) {
        if (username.equals("admin") ) {
            return "admin";
        }else {
            throw new CustomerException("账号错误");
        }
    }
}
