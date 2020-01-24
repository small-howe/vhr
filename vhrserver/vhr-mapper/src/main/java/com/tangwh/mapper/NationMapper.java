package com.tangwh.mapper;

import com.tangwh.pojo.Nation;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}