package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Politicsstatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 政治面貌
 */
@Mapper
public interface PoliticsstatusExtMapper {
    List<Politicsstatus> getAllPoliticsstatus();
}
