package com.tangwh.controller.system.basic;

import com.tangwh.pojo.Role;
import com.tangwh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限组
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    /**
     * 获取所有的角色
     * @return
     */
    @GetMapping("/")
    public List<Role> getAllRoles(){

        return roleService.getAllRoles();
    }




}
