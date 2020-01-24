package com.tangwh.controller.system.basic;

import com.tangwh.pojo.Joblevel;
import com.tangwh.pojo.RespEntity;
import com.tangwh.service.JoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 职称管理
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    JoblevelService joblevelService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/")
    public List<Joblevel> getAllJob() {

        return joblevelService.getAllJobLevels();
    }


    @PostMapping("/")
    public RespEntity addJoblevel(@RequestBody Joblevel joblevel) {

        if (joblevelService.addJoblevel(joblevel) == 1) {
            return RespEntity.ok("添加成功");
        }
        return RespEntity.error("添加失败");
    }

    @PutMapping("/")
    public RespEntity updateJoblevel(@RequestBody Joblevel joblevel){
        if (joblevelService.updateJoblevel(joblevel) == 1){
           return RespEntity.ok("更新成功");
        }
        return  RespEntity.error("更新失败");

    }

    @DeleteMapping("/{id}")
    public RespEntity deleteJoblevel(@PathVariable Integer id){
        if (joblevelService.deleteJoblevel(id) == 1 ){

            return RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");

    }


    @DeleteMapping("/")
    public RespEntity deleteJobLevelsByIds(Integer[] ids) {
        if (joblevelService.deleteJoblevelByIds(ids) == ids.length) {
            return RespEntity.ok("删除成功");

        }
        return RespEntity.error("删除失败");


    }

}
