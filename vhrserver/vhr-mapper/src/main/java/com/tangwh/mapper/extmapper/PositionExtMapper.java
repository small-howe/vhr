package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PositionExtMapper {

    /**
     * 查询全部信息
     * @return
     */
    List<Position> getAllPositions();

    Integer deletePositionByIds(@Param("ids") Integer[] ids);
}
