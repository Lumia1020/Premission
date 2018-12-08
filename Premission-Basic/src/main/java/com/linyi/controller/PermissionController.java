package com.linyi.controller;

import com.linyi.model.Permission;
import com.linyi.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping("listPermission")
    public ModelAndView listPermission(){
        return  new ModelAndView("permission.jsp").addObject("permissions",this.permissionService.selectAll());
    }

    @RequestMapping("addPermission")
    @ResponseBody
    public String addPermission(Permission permission){
        return  this.permissionService.insert(permission)>0?"success":"error";
    }
}
