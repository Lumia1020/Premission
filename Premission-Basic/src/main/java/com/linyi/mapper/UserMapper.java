package com.linyi.mapper;

import com.linyi.model.Role;
import com.linyi.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // 删除
    int deleteByPrimaryKey(Integer id);

    // 插入
    int insert(User record);

    // 查询
    User selectByPrimaryKey(Integer id);


    // 查询所有
    List<User> selectAll();

    // 更新
    int updateByPrimaryKey(User record);


    // 查询用户所有角色
    List<Role> selectRolesByPrimaryKey(Integer id);

    // 删除用户角色
    int deleteRoles(Integer id);

    // 新增用户角色
    int insertRole(@Param("role_id") Integer roleId,@Param("user_id")Integer userId);

    User selectUserByUserNameAndPassword(@Param("username")  String username,@Param("password") String password);
}