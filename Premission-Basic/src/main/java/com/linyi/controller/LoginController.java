package com.linyi.controller;

import com.linyi.model.User;
import com.linyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession httpSession){
        User user=this.userService.selectUserByUserNameAndPassword(username,password);
        if (user!=null){
           httpSession.setAttribute("user",user);
        }else
            return "用户不存在";
        return "登陆成功";
    }


}
