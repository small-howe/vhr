package com.tangwh.mapper;

import com.tangwh.pojo.Msgcontent;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface MsgcontentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}