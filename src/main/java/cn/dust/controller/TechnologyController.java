package cn.dust.controller;

import cn.dust.domain.ResponseBean;
import cn.dust.domain.Technology;
import cn.dust.service.TecService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TechnologyController {
    @Autowired
    private TecService tecService;

    @PostMapping("/public/getTecById")
    public ResponseBean getTecById(@RequestParam int tecId){
        try{
            ResponseBean result=tecService.getTecById(tecId);
            if(result.getMsg().equals("搜索成功")){
                return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",result.getData());
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
        }
    }

    @PostMapping("/public/getTecByName")
    public ResponseBean getTecByName(@RequestParam String tecName){
        try{
            ResponseBean result=tecService.getTecByName(tecName);
            if(result.getMsg().equals("搜索成功")){
                return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",result.getData());
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
        }
    }

    @PostMapping("/public/deleteTecById")
    public ResponseBean deleteTecById(@RequestParam int tecId){
        try{
            int result=tecService.deleteTecById(tecId);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"删除成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
        }
    }

    @PostMapping("/public/deleteTecByName")
    public ResponseBean deleteTecByName(@RequestParam String tecName){
        try{
            int result=tecService.deleteTecByName(tecName);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"删除成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
        }
    }

    @PostMapping("/public/insertTec")
    public ResponseBean insertTec(@RequestBody Technology tec){
        try{
            int result=tecService.insertTec(tec);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"插入成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"插入失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"插入失败",null);
        }

    }

    @PostMapping("/public/updateTecClicksById")
    public ResponseBean updateTecClicksById(@RequestParam int tecId) {
        try {
            int result=tecService.updateTecClicksById(tecId);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"更新成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE, "更新失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE, "更新失败", null);
        }
    }

    @PostMapping("/public/updateTec")
    public ResponseBean updateTec(@RequestBody Technology tec){
        try {
            System.out.println(tec);
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            tec.setTecTime(timestamp);
            System.out.println(tec.getTecTime()+"=====================================================");
            int result=tecService.updateTec(tec);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"更新成功",null);
            }else{
                return  new ResponseBean(ResponseBean.FAILURE,"更新失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseBean(ResponseBean.FAILURE,"更新失败",null);
        }
    }

    @PostMapping("/public/selectAllTec")
    public ResponseBean getAllUsers(@Param("page") int page){
        ResponseBean result = tecService.selectAllNews(page);
        if(result.getMsg().equals("查询成功")) {
            return new ResponseBean(ResponseBean.SUCCESS,"查询成功",result.getData());
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"查询失败",null);
        }
    }

}
