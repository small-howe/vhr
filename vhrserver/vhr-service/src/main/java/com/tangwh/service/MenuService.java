package com.tangwh.service;

import com.tangwh.mapper.extmapper.MenuExtMapper;
import com.tangwh.mapper.extmapper.MenuRoleExtMapper;
import com.tangwh.pojo.Hr;
import com.tangwh.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuExtMapper menuExtMapper;

    @Autowired
    MenuRoleExtMapper menuRoleExtMapper;

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

    /**
     * 查询所有的菜单项
     *
     * @return
     */
    public List<Menu> getAllMenus() {
        return menuExtMapper.getAllMenus();
    }


    public List<Integer> getMidsByRid(Integer rid) {
        return menuExtMapper.getMidsByRid(rid);
    }

    /**
     * 更新操作 先删除原来的 然后重新添加新的资源
     *
     * @param rid
     * @param mids
     * @return
     */

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        // 先删除原来的
        menuRoleExtMapper.deleeByRid(rid);
        //重新添加
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleExtMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
