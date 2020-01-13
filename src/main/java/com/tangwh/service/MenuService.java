package com.tangwh.service;

import com.tangwh.mapper.MenuMapper;
import com.tangwh.mapper.extmapper.MenuExtMapper;
import com.tangwh.pojo.Hr;
import com.tangwh.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuExtMapper menuExtMapper;


    public List<Menu> getMenusByHrId() {
// 首先获取到这个Hr id 这个Id 不能让前端去传送  由于我们也保存了用户信息
// 当前登陆的hr对象
        //SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        return menuExtMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }
}
