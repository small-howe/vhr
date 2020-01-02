package com.tangwh.mapper;

import com.tangwh.pojo.Sysmsg;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface SysmsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}