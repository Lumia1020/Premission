package com.linyi.controller;

import com.linyi.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    public void test1(){
        this.userService.selectAll();
    }
}
