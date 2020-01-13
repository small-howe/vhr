package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuExtMapper {


    /**
     * 通过 Hr 的id 查询拥有的菜单
     * @param id
     * @return
     */
    List<Menu> getMenusByHrId(Integer id);
}
