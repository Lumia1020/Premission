package com.linyi.mapper;

import com.linyi.model.Permission;
import com.linyi.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    // 删除
    int deleteByPrimaryKey(Integer id);

    // 新增
    int insert(Role record);

    // 查询
    Role selectByPrimaryKey(Integer id);

    // 查询所有
    List<Role> selectAll();

    // 更新
    int updateByPrimaryKey(Role record);

    // 查询角色所有权限
    List<Permission> selectPermissionsByPrimarKey(Integer id);

    // 删除角色权限
    int deletePermissions(Integer id);

    // 新增角色权限
    int insertPermission(@Param("role_id") Integer roleId,@Param("permission_id") Integer permissionId);
}