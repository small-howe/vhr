package com.tangwh.service;

import com.tangwh.mapper.RoleMapper;
import com.tangwh.mapper.extmapper.RoleExtMapper;
import com.tangwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleExtMapper roleExtMapper;

    @Autowired
    RoleMapper roleMapper;
    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> getAllRoles() {
        return roleExtMapper.getAllRoles();
    }

    /**
     * 添加操作
     *
     * @param role
     * @return
     */
    public Integer addRole(Role role) {
        // 判断role 时候有前缀ROLE_ 是不是一ROLE_开始
        if (!role.getName().startsWith("ROLE_")){
             role.setName("ROLE_"+role.getName());
        }
      return   roleMapper.insertSelective(role);
    }

    /**
     * 删除操作
     *
     * @param rid
     * @return
     */
    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
