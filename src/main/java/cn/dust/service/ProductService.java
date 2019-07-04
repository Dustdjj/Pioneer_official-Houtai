package cn.dust.service;

import cn.dust.domain.Product;
import cn.dust.domain.ResponseBean;

public interface ProductService {

    ResponseBean getAllProducts(int page);

    int deleteProductById(int id);

    int deleteProductByName(String name);

    ResponseBean selectProductById(int id);

    ResponseBean selectProductByName(String productName);

    int insertProduct(Product product);

    int updateProduct(Product product);
}
