package com.tangwh.mapper;

import com.tangwh.pojo.Joblevel;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
}