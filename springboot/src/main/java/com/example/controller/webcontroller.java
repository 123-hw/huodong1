package com.example.controller;
import com.example.common.Result;
import com.example.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class webcontroller {
    @Resource
    AdminService adminService;
    //表示get请求
    @GetMapping("/hello")//接口唯一
    public Result hello() {
        int a=1/0;
        return Result.success("hello");
    }
    @GetMapping("/admin")
    public Result admin(String name) {
        String adminName = adminService.admin(name);
        return Result.success(adminName);
    }

}
