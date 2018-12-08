package com.linyi.service;

import com.linyi.mapper.PermissionMapper;
import com.linyi.model.Permission;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    public List<Permission> selectAll() {
        return this.permissionMapper.selectAll();
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.permissionMapper.deleteByPrimaryKey(id);
    }


    public int insert(Permission record) {
        return this.permissionMapper.insert(record);
    }


    public Permission selectByPrimaryKey(Integer id) {
        return this.permissionMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Permission record) {
        return this.permissionMapper.updateByPrimaryKey(record);
    }

}
