package com.tangwh.service;

import com.tangwh.mapper.NationMapper;
import com.tangwh.mapper.extmapper.NationExtMapper;
import com.tangwh.pojo.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 民族
 */
@Service
public class NationService {

    @Autowired
    NationExtMapper nationExtMapper;

    /**
     * 查询民族
     * @return
     */
    public List<Nation> getAllNations() {
        return nationExtMapper.getAllNations();
    }
}
