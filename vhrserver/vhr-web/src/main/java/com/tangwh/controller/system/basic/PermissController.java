package com.tangwh.controller.system.basic;

import com.tangwh.pojo.Menu;
import com.tangwh.pojo.RespEntity;
import com.tangwh.pojo.Role;
import com.tangwh.service.MenuService;
import com.tangwh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限组 接口
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    /**
     * 获取所有的角色
     * @return
     */
    @GetMapping("/")
    public List<Role> getAllRoles(){

        return roleService.getAllRoles();
    }

    /**
     * 查询所有的菜单栏目 一级 菜单以及二级菜单
     * @return
     */
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {

        return menuService.getAllMenus();
    }

    /**
     * 根据角色id  查询菜单id
     * @param rid
     * @return
     */
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){

        return menuService.getMidsByRid(rid);
    }


    /**
     * 更新操作  根据角色id 来更新资源
     * @param rid
     * @param mids
     * @return
     */
    @PutMapping("/")
    public RespEntity updateMenuRole(Integer rid,Integer[] mids){

        if (menuService.updateMenuRole(rid,mids)){
            return  RespEntity.ok("更新成功");
        }
        return RespEntity.error("更新失败");
    }

    /**
     * 添加操作
     * @param role
     * @return
     */
    @PostMapping("/role")
    public RespEntity addRole(@RequestBody Role role){
       if (roleService.addRole(role)==1){
           return RespEntity.ok("添加成功");
       }
       return RespEntity.error("添加失败");

    }

    /**
     * 删除操作
     * @param rid
     * @return
     */
    @DeleteMapping("/role/{rid}")
    public RespEntity deleteRoleById(@PathVariable Integer rid){

        if (roleService.deleteRoleById(rid) == 1){
            return RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");
    }

}
