package cn.dust.service;

import cn.dust.domain.ResponseBean;
import cn.dust.domain.Technology;

public interface TecService {
    ResponseBean getTecById(int id);

    ResponseBean getTecByName(String name);

    ResponseBean selectAllNews(int page);

    int deleteTecById(int id);

    int deleteTecByName(String name);

    int insertTec(Technology tec);

    int updateTecClicksById(int id);

    int updateTec(Technology tec);


}
