package com.tangwh.service;

import com.tangwh.mapper.PositionMapper;
import com.tangwh.mapper.extmapper.PositionExtMapper;
import com.tangwh.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionExtMapper positionExtMapper;

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionExtMapper.getAllPositions();
    }


    public Integer addPosition(Position position) {
        position.setEnabled(true);
        // 添加的时候 创建时间
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }


    /**
     * 更新操作
     *
     * @param position
     * @return
     */
    public Integer updatePosition(Position position) {

        return positionMapper.updateByPrimaryKeySelective(position);
    }

    /**
     * 删除操作
     *
     * @param id
     * @return
     */
    public Integer deletePositionById(Integer id) {

        return positionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public Integer deletePositionByIds(Integer[] ids) {

        return  positionExtMapper.deletePositionByIds(ids);
    }
}
