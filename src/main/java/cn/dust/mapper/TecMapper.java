package cn.dust.mapper;

import cn.dust.domain.Technology;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TecMapper {

    Technology getTecById(int id);

    List<Technology> getTecByName(@Param("tecTitle") String name);

    int deleteTecById(int id);

    int deleteTecByName(String name);

    int insertTec(Technology tec);

    int updateTecClicksById(int id);

    int updateTec(Technology tec);

    List<Technology> selectAllNews();

}
