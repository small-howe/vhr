package com.tangwh.mapper;

import com.tangwh.pojo.Position;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}