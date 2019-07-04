package cn.dust.service;

import cn.dust.domain.News;
import cn.dust.domain.ResponseBean;

public interface NewsService {
    ResponseBean getNewsById(int id);

    ResponseBean getNewsByName(String name);

    ResponseBean selectAllNews(int page);

    int deleteNewsById(int id);

    int deleteNewsByName(String name);

    int insertNews(News news);

    int updateNewsClicksById(int id);

    int updateNews(News news);
}
