package cn.dust.service.impl;

import cn.dust.domain.Product;
import cn.dust.domain.ResponseBean;
import cn.dust.mapper.ProductMapper;
import cn.dust.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseBean getAllProducts(int page) {
        PageHelper.startPage(page, 10);
        List<Product> products = productMapper.getAllProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",pageInfo);
    }

    @Override
    public int deleteProductById(int id) {
        return productMapper.deleteProductById(id);
    }

    @Override
    public int deleteProductByName(String name) {
        return productMapper.deleteProductByName(name);
    }

    @Override
    public ResponseBean selectProductById(int id) {
        Product product=productMapper.getProductById(id);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",product);
    }

    @Override
    public ResponseBean selectProductByName(String productName) {
        List<Product> products=productMapper.getProductByName(productName);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",products);
    }


    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }
}
