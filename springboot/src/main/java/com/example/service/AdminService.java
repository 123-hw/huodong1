package com.example.service;

import com.example.entity.Admin;
import com.example.exception.CustomerException;
import com.example.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return adminMapper.selectAll(null);
    }

    public PageInfo<Admin> selectPage(Integer pageNum, Integer pageSize,Admin admin) {
        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminMapper.selectAll(admin);
        return PageInfo.of(list);
    }
}
