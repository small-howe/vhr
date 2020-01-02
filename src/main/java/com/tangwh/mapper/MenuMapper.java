package com.tangwh.mapper;

import com.tangwh.pojo.Menu;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}