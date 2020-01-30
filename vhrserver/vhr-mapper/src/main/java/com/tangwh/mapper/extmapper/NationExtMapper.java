package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Nation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * 民族
 */
@Mapper
public interface NationExtMapper {

    List<Nation> getAllNations();
}
