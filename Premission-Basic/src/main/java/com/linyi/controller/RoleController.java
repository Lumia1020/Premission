package com.linyi.controller;

import com.linyi.model.Permission;
import com.linyi.model.Role;
import com.linyi.service.PermissionService;
import com.linyi.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @RequestMapping("listRole")
    public ModelAndView listRole(){
        return new ModelAndView("role.jsp").addObject("roles",this.roleService.selectAll());
    }

    @RequestMapping("addRole")
    @ResponseBody
    public String addRoleSubmit(Role role){
       return this.roleService.insert(role)>0?"success":"error";
    }

    @RequestMapping("grantPermissionView")
    public ModelAndView grantPermissionView(Integer id){
        ModelAndView modelAndView=new ModelAndView("grant-permission.jsp");
        List<Permission> permissions=this.permissionService.selectAll();
        List<Permission> grantPermission=this.roleService.selectPermissionsByPrimarKey(id);
        Role role=this.roleService.selectByPrimaryKey(id);
        return  modelAndView.addObject("permissions",permissions).addObject("grantPermission",grantPermission).addObject("role",role);
    }

    @RequestMapping("grantPermission")
    @ResponseBody
    public String grantPermission(Integer id,Integer[] permissionId){
        this.roleService.insertPermission(id,permissionId);
        return  "success";
    }
}
