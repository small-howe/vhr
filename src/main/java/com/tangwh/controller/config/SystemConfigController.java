package com.tangwh.controller.config;

import com.tangwh.pojo.Menu;
import com.tangwh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {


    @Autowired
    MenuService menuService;

    /**
     *    根据登录用户的ID 来动态获取菜单项数据
     * @return
     */
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){

        return menuService.getMenusByHrId();
    }
}
