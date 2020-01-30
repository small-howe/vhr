package com.tangwh.service;

import com.tangwh.mapper.extmapper.PoliticsstatusExtMapper;
import com.tangwh.pojo.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 政治面貌
 */
@Service
public class PoliticsstatusService {

    @Autowired
    PoliticsstatusExtMapper politicsstatusExtMapper;

    /**
     * 政治面貌
     *
     * @return
     */
    public List<Politicsstatus> getAllPoliticsstatus() {

        return politicsstatusExtMapper.getAllPoliticsstatus();

    }
}
