package com.tangwh.mapper;

import com.tangwh.pojo.Hr;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * 自 通过用户名查询
     * @param username
     * @return
     */
    Hr loadUserByUsername(String username);
}