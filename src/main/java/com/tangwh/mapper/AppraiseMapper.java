package com.tangwh.mapper;

import com.tangwh.pojo.Appraise;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:12
 * @version 1.0
 */
public interface AppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}