package com.tangwh.mapper;

import com.tangwh.pojo.Oplog;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface OplogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    Oplog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}