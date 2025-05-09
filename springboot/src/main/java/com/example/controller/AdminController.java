package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {  // @RequestBody 接收前端传来的 json参数
        adminService.update(admin);
        return Result.success();
    }


    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {  // @PathVariable 接收前端传来的路径参数
        adminService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Admin> list) {  //  @RequestBody 接收前端传来的 json数组
        adminService.deleteBatch(list);
        return Result.success();
    }


    @GetMapping("/selectAll")//http://9999/admin/selectAll
    public Result selectAll() {
        List<Admin> adminList =adminService.selectAll();
        return Result.success(adminList);
    }

    /**
     * 分页查询
     *  pageNum： 当前的页码
     *  pageSize  每页个数
     *
     */

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1")  Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Admin admin) {
        PageInfo<Admin>pageInfo = adminService.selectPage(pageNum,pageSize,admin);
        return Result.success(pageInfo);//返回的是分页的对象
    }

}
