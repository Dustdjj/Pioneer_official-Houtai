package cn.dust.service.impl;

import cn.dust.domain.News;
import cn.dust.domain.ResponseBean;
import cn.dust.mapper.NewsMapper;
import cn.dust.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public ResponseBean getNewsById(int id) {
        News news=newsMapper.getNewsById(id);
        return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",news);
    }

    @Override
    public ResponseBean getNewsByName(String name) {
        List<News> news=newsMapper.getNewsByName(name);
        return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",news);
    }

    @Override
    public ResponseBean selectAllNews(int page) {
        PageHelper.startPage(page, 10);
        List<News> news = newsMapper.selectAllNews();
        PageInfo<News> pageInfo = new PageInfo<>(news);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",pageInfo);
    }

    @Override
    public int deleteNewsById(int id) {
        return newsMapper.deleteNewsById(id);
    }

    @Override
    public int deleteNewsByName(String name) {
        return newsMapper.deleteNewsByName(name);
    }

    @Override
    public int insertNews(News news) {
        return newsMapper.insertNews(news);
    }

    @Override
    public int updateNewsClicksById(int id) {
        return newsMapper.updateNewsClicksById(id);
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateNews(news);
    }
}
