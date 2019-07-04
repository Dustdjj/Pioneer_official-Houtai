package cn.dust.service.impl;

import cn.dust.domain.ResponseBean;
import cn.dust.domain.Technology;
import cn.dust.mapper.TecMapper;
import cn.dust.service.TecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecServiceImpl implements TecService {
    @Autowired
    private TecMapper tecMapper;

    @Override
    public ResponseBean getTecById(int id) {
        Technology tec=tecMapper.getTecById(id);
        return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",tec);
    }

    @Override
    public ResponseBean getTecByName(String name) {
        List<Technology> tec=tecMapper.getTecByName(name);
        return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",tec);
    }

    @Override
    public ResponseBean selectAllNews(int page) {
        PageHelper.startPage(page, 10);
        List<Technology> tec = tecMapper.selectAllNews();
        PageInfo<Technology> pageInfo = new PageInfo<>(tec);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",pageInfo);
    }

    @Override
    public int deleteTecById(int id) {
        return tecMapper.deleteTecById(id);
    }

    @Override
    public int deleteTecByName(String name) {
        return tecMapper.deleteTecByName(name);
    }

    @Override
    public int insertTec(Technology tec) {
        return tecMapper.insertTec(tec);
    }

    @Override
    public int updateTecClicksById(int id) {
        return tecMapper.updateTecClicksById(id);
    }

    @Override
    public int updateTec(Technology tec) {
        return tecMapper.updateTec(tec);
    }
}
