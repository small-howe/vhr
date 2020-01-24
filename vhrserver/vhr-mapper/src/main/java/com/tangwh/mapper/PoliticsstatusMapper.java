package com.tangwh.mapper;

import com.tangwh.pojo.Politicsstatus;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface PoliticsstatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);
}