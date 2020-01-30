package com.tangwh.service;

import com.tangwh.mapper.JoblevelMapper;
import com.tangwh.mapper.extmapper.JoblevelExtMapper;
import com.tangwh.pojo.Joblevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JoblevelService {

    @Autowired
    JoblevelExtMapper joblevelExtMapper;

    @Autowired
    JoblevelMapper joblevelMapper;


    /**
     * 职称查询
     * @return
     */
    public List<Joblevel> getAllJobLevels() {
        return joblevelExtMapper.getAllJobLevels();
    }

    public Integer addJoblevel(Joblevel joblevel) {
        joblevel.setCreateDate(new Date());
        joblevel.setEnabled(true);
        return joblevelMapper.insertSelective(joblevel);
    }

    public Integer updateJoblevel(Joblevel joblevel) {
        return joblevelMapper.updateByPrimaryKeySelective(joblevel);
    }

    public Integer deleteJoblevel(Integer id) {
        return joblevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJoblevelByIds(Integer[] ids) {
        return joblevelExtMapper.deleteJoblevelByIds(ids);
    }


}
