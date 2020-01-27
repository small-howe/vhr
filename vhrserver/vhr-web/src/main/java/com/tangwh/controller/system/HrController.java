package com.tangwh.controller.system;

import com.tangwh.pojo.Hr;
import com.tangwh.pojo.RespEntity;
import com.tangwh.pojo.Role;
import com.tangwh.service.HrService;
import com.tangwh.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作员管理
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    /**
     * 获取Hr 的信息 包括权限
     * @return
     */
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);

    }

    /**
     * 修改是否禁用状态 更新Hr的
     * @param hr
     * @return
     */
    @PutMapping("/")
    public RespEntity updateHr(@RequestBody Hr hr){

        if (hrService.updateHr(hr) == 1){
            return RespEntity.ok("更新成功");
        }
        return RespEntity.error("更新失败");

    }

    /**
     * 查询所有的角色
     * @return
     */
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    /**
     * 更新Hr 角色
     * @param hrid
     * @param rids
     * @return
     */
    @PutMapping("/role")
    public RespEntity updateHrRole(Integer hrid,Integer[] rids){
        if (hrService.updateHrRole(hrid,rids)){
            return RespEntity.ok("更新成功");

        }
        return RespEntity.error("更新失败");

    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespEntity deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id) == 1){
            return RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");
    }


}
