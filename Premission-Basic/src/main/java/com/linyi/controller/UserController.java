package com.linyi.controller;

import com.linyi.model.Role;
import com.linyi.model.User;
import com.linyi.service.RoleService;
import com.linyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping("addUser")
    @ResponseBody
    public String addUserSubmit(User user) {
        return userService.insert(user) > 0 ? "success" : "error";
    }

    @RequestMapping("listUser")
    public ModelAndView listUser() {
         return new ModelAndView("user.jsp").addObject("users", this.userService.selectAll());
    }

    @RequestMapping("grantRoleView")
    public ModelAndView grantRoleView(Integer id){
        List<Role> roles=this.roleService.selectAll();
        List<Role> grantRole=this.userService.selectRolesByPrimaryKey(id);
        User user=this.userService.selectByPrimaryKey(id);
        return  new ModelAndView("grant-role.jsp").addObject("roles",roles).addObject("grantRole",grantRole).addObject("user",user);
    }

    @RequestMapping("grantRole")
    @ResponseBody
    public String grantRole(Integer id,Integer[] roleId){
        this.userService.insertRole(roleId,id);
        return  "success";

    }


}
