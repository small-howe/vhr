package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Joblevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JoblevelExtMapper {

    List<Joblevel> getAllJobLevels();

    // 批量删除
    Integer deleteJoblevelByIds(@Param("ids") Integer[] ids);
}
