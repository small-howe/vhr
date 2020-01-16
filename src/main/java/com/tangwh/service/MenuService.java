package com.tangwh.service;

import com.tangwh.mapper.MenuMapper;
import com.tangwh.mapper.extmapper.MenuExtMapper;
import com.tangwh.pojo.Hr;
import com.tangwh.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuExtMapper menuExtMapper;

    /**
     *  根据用户id查询 查询所拥有的菜单项目
     * @return
     */
    public List<Menu> getMenusByHrId() {
 // 首先获取到这个Hr id 这个Id 不能让前端去传送  由于我们也保存了用户信息
 // 当前登陆的hr对象
        //SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        return menuExtMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }


    //@Cacheable 实战中必须加上缓存heredis

    /**
     * 获取所有的请求连接
     * @return
     */
    public List<Menu> getAllMenusWithRole(){
        return menuExtMapper.getAllMenusWithRole();

    }

}
