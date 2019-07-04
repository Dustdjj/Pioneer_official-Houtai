package cn.dust.controller;

import cn.dust.domain.News;
import cn.dust.domain.ResponseBean;
import cn.dust.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/public/getNewsById")
    public ResponseBean getNewsById(@RequestParam int newsId){
        try{
            ResponseBean result=newsService.getNewsById(newsId);
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

    @PostMapping("/public/getNewsByName")
    public ResponseBean getNewsByName(@RequestParam String newsName){
        try{
            ResponseBean result=newsService.getNewsByName(newsName);
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

    @PostMapping("/public/deleteNewsById")
    public ResponseBean deleteNewsById(@RequestParam("newsId") int newsId){
        try{
            int result=newsService.deleteNewsById(newsId);
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

    @PostMapping("/public/deleteNewsByName")
    public ResponseBean deleteNewsByName(@RequestParam String newsName){
        try{
            int result=newsService.deleteNewsByName(newsName);
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

    @PostMapping("/public/insertNews")
    public ResponseBean insertNews(@RequestBody News news){
        try{
            int result=newsService.insertNews(news);
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

    @PostMapping("/public/updateNewsClicksById")
    public ResponseBean updateNewsClicksById(@RequestParam int newsId) {
        try {
            int result=newsService.updateNewsClicksById(newsId);
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

    @PostMapping("/public/updateNews")
    public ResponseBean updateNews(@RequestBody News news){
        try {
            System.out.println(news);
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            news.setNewsTime(timestamp);
            System.out.println(news.getNewsTime()+"=====================================================");
            int result=newsService.updateNews(news);
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

    @PostMapping("/public/getAllNews")
    public ResponseBean getAllUsers(@Param("page") int page){
        ResponseBean result = newsService.selectAllNews(page);
        if(result.getMsg().equals("查询成功")) {
            return new ResponseBean(ResponseBean.SUCCESS,"查询成功",result.getData());
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"查询失败",null);
        }
    }

}
