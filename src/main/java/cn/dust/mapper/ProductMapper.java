package cn.dust.mapper;

import cn.dust.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product getProductById(int productId);

    List<Product> getProductByName(@Param("productName") String productName);

    List<Product> getAllProducts();

    int deleteProductById(int id);

    int deleteProductByName(String name);

    int insertProduct(Product product);

    int updateProduct(Product product);


}
