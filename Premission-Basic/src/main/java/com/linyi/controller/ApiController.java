package com.linyi.controller;

import com.linyi.annotation.RequiredPermission;
import com.linyi.annotation.RequiredRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/add")
    @RequiredRole("admin_normal")
    @RequiredPermission("add")
    public String add(){
        return "添加数据成功";
    }

    @RequiredPermission("delete")
    @RequestMapping("/delete")
    public String delete() {
        return "删除数据成功";
    }

    @RequiredPermission("select")
    @RequiredRole("admin")
    @RequestMapping("/select")
    public String select() {
        return "查询数据成功";
    }
}
