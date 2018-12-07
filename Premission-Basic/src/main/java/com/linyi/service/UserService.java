package com.linyi.service;

import com.linyi.mapper.UserMapper;
import com.linyi.model.Role;
import com.linyi.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 删除
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    // 插入
    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    // 查询
    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    // 查询所有
    public List<User> selectAll() {
        return this.userMapper.selectAll();
    }

    // 更新
    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }


    // 查询用户所有角色
    public List<Role> selectRolesByPrimaryKey(Integer id) {
        return this.userMapper.selectRolesByPrimaryKey(id);
    }

    // 删除用户角色
    public int deleteRoles(Integer id) {
        return this.userMapper.deleteRoles(id);
    }

    // 新增用户角色
    public int insertRole(@Param("role_id") Integer roleId, @Param("user_id") Integer userId) {
        return this.userMapper.insertRole(roleId, userId);
    }
}
