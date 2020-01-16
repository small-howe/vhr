package com.tangwh.controller.system.basic;

import com.tangwh.pojo.Position;
import com.tangwh.pojo.RespEntity;
import com.tangwh.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    /**
     * 查询全部所有信息
     *
     * @return
     */
    @GetMapping("/")
    public List<Position> getAllPositions() {

        return positionService.getAllPositions();
    }

    /**
     * 添加  传递json
     *
     * @param position
     * @return
     */
    @PostMapping("/")
    public RespEntity addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {

            return RespEntity.ok("添加成功");
        }
        return RespEntity.error("添加失败");
    }


    /**
     * 更新
     *
     * @param position
     * @return
     */
    @PutMapping("/")
    public RespEntity updatePosition(@RequestBody Position position) {

        if (positionService.updatePosition(position) == 1) {
            return RespEntity.ok("更新成功");
        }
        return RespEntity.error("更新失败");
    }


    /**
     * 删除操作
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public RespEntity deletePositionById(@PathVariable(name = "id") Integer id) {


        if (positionService.deletePositionById(id) == 1) {
            return RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public RespEntity deletePositionByIds(Integer[] ids) {

        if (positionService.deletePositionByIds(ids) == (ids.length)) {
          return   RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");

    }


}
