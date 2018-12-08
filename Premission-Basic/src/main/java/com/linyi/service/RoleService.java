package com.linyi.service;

import com.linyi.mapper.RoleMapper;
import com.linyi.model.Permission;
import com.linyi.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RoleService {

    @Resource
    private RoleMapper roleMapper;
    // 查询
    public Role selectByPrimaryKey(Integer id){
        return  this.roleMapper.selectByPrimaryKey(id);
    }

    // 查询所有
    public List<Role> selectAll(){
        return this.roleMapper.selectAll();
    }

    // 新增
    public int insert(Role record){
       return this.roleMapper.insert(record);
    }

    // 查询角色所有权限
    public List<Permission> selectPermissionsByPrimarKey(Integer id){
        return this.roleMapper.selectPermissionsByPrimarKey(id);
    }

    // 删除角色权限
    public  int deletePermissions(Integer id){
        return  this.roleMapper.deletePermissions(id);
    }

    // 新增角色权限
    public int insertPermission( Integer roleId,Integer permissionId){
        return  this.roleMapper.insertPermission(roleId,permissionId);
    }

    public void insertPermission( Integer roleId,Integer[] permissionIds){
       // 删除角色权限
        this.roleMapper.deletePermissions(roleId);
        if (permissionIds!=null){
            for(Integer item :permissionIds){
                this.roleMapper.insertPermission(roleId,item);
            }
        }
    }

}
