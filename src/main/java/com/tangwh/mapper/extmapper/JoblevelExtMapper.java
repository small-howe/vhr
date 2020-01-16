package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Joblevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoblevelExtMapper {

    List<Joblevel> getAllJobLevels();
}
