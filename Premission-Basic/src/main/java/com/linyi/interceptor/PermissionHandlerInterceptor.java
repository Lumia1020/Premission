package com.linyi.interceptor;

import com.linyi.annotation.RequiredPermission;
import com.linyi.annotation.RequiredRole;
import com.linyi.model.Permission;
import com.linyi.model.Role;
import com.linyi.model.User;
import com.linyi.service.RoleService;
import com.linyi.service.UserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class PermissionHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Method method = ((HandlerMethod) handler).getMethod();
        RequiredPermission requiredPermission = method.getAnnotation(RequiredPermission.class);
        RequiredRole requiredRole = method.getDeclaredAnnotation(RequiredRole.class);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.getWriter().print("该用户未登陆！");
            return false;
        }


        List<Role> roles = this.userService.selectRolesByPrimaryKey(user.getId());
        if (requiredRole != null) {
            for (Role role : roles) {
                if (role.getName().equals(requiredRole.value()))
                   return true;
            }
        }


        if (requiredPermission != null) {
            for (Role role : roles) {
                List<Permission> permissions = this.roleService.selectPermissionsByPrimarKey(role.getId());
                if (permissions != null) {
                    for (Permission permission : permissions) {
                        if (permission.getName().equals(requiredPermission.value()))
                            return true;
                    }
                }
            }
        }
        response.getWriter().print("权限不足！");
        return  false;
    }

}
