package cn.dust;

import cn.dust.domain.News;
import cn.dust.domain.Product;
import cn.dust.domain.User;
import cn.dust.mapper.NewsMapper;
import cn.dust.mapper.ProductMapper;
import cn.dust.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class Test {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private NewsMapper newsMapper;

    @org.junit.Test
    public void selectAllIdANDTile(){
      List<News>list=  newsMapper.selectAllNews();
        System.out.println(list.toString());
    }

    @org.junit.Test
    public void updateNewsClicksById(){
        newsMapper.updateNewsClicksById(3);
    }
    @org.junit.Test
    public void updateNews(){
        newsMapper.updateNews(new News(3,"卧底",new Timestamp(System.currentTimeMillis()),"3",30,"/static/news"));
    }
    @org.junit.Test
    public void insertNews(){
        newsMapper.insertNews(new News("3",new Timestamp(System.currentTimeMillis()),"3",30,"/static/news"));
    }
    @org.junit.Test
    public void deleteNewsById(){
        newsMapper.deleteNewsById(3);
    }
    @org.junit.Test
    public void deleteNewsByName(){
        newsMapper.deleteNewsByName("4");
    }
    @org.junit.Test
    public void getNewsByName(){
        List<News> news=newsMapper.getNewsByName("a");
        System.out.println(news.toString());
    }
    @org.junit.Test
    public void getNewsById(){
        News news=newsMapper.getNewsById(1);
        System.out.println(news.toString());
    }
    @org.junit.Test
    public void deleteProductById(){
        productMapper.deleteProductById(4);
    }
    @org.junit.Test
    public void deleteProductByName(){
        productMapper.deleteProductByName("罗姆");
    }
    @org.junit.Test
    public void updateProduct(){
     productMapper.updateProduct(new Product(4,"4","5","/static/img"));
    }
    @org.junit.Test
    public void insertProduct(){
        productMapper.insertProduct(new Product("xxx","fhwefhiu","/static/img"));
    }
    @org.junit.Test
    public void getAllProduct(){
        List<Product>list=productMapper.getAllProducts();
        System.out.println(list.toString());
    }
    @org.junit.Test
    public void getProductById(){
        Product product= productMapper.getProductById(2);
        System.out.println(product.toString());
    }
    @org.junit.Test
    public void getProductByName(){
        List<Product> products=productMapper.getProductByName("u");
        System.out.println(products.toString());
    }
    @org.junit.Test
    public void allUser(){
       List<User>list=userMapper.getAllUsers();
       System.out.println(list.toString());
    }
    @org.junit.Test
    public void deleteUser(){
        userMapper.deleteUserById(2);
    }
    @org.junit.Test
    public void getUserByName(){
        User user=userMapper.getUserByName("dust");
        System.out.println(user.toString());
    }
    @org.junit.Test
    public void getUserNameById(){
        User user=userMapper.selectUserById(2);
        System.out.println(user.toString());
    }
    @org.junit.Test
    public void insertUser(){

        userMapper.insertUser(new User("fr","123321"));
    }
    @org.junit.Test
    public void updateUser(){
        userMapper.updateUser(new User(2,"ff","666666"));
    }




}
