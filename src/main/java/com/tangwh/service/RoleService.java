package com.tangwh.service;

import com.tangwh.mapper.extmapper.RoleExtMapper;
import com.tangwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleExtMapper roleExtMapper;

    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> getAllRoles() {
        return roleExtMapper.getAllRoles();
    }
}
