package cn.dust.mapper;

import cn.dust.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {

    News getNewsById(int id);

    List<News> getNewsByName(@Param("newsTitle") String name);

    int deleteNewsById(int id);

    int deleteNewsByName(String name);

    int insertNews(News news);

    int updateNewsClicksById(int id);

    int updateNews(News news);

    List<News> selectAllNews();

}
