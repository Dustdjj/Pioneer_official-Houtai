package cn.dust.controller;

import cn.dust.domain.Product;
import cn.dust.domain.ResponseBean;
import cn.dust.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/public/getAllProduct")
    public ResponseBean getAllProduct(@RequestParam("page") int page){
        ResponseBean result=productService.getAllProducts(page);
        if(result.getMsg().equals("查询成功")) {
            return new ResponseBean(ResponseBean.SUCCESS,"查询成功",result.getData());
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"查询失败",null);
        }
    }

    @PostMapping("/public/deleteProductById")
    public ResponseBean deleteUserById(@RequestParam("productId") int productId) {
        int result = productService.deleteProductById(productId);
        if(result > 0 ){
            return new ResponseBean(ResponseBean.SUCCESS,"删除成功",null);
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
        }

    }

    @PostMapping("/public/deleteProductByName")
    public ResponseBean deleteUserById(@RequestParam("productName") String productName) {
        int result = productService.deleteProductByName(productName);
        if(result > 0 ){
            return new ResponseBean(ResponseBean.SUCCESS,"删除成功",null);
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
        }

    }

    @PostMapping("/public/updateProductById")
    public ResponseBean updateProductById(@RequestBody Product product){
        try {
            int result=productService.updateProduct(product);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"更新成功",null);
            }else{
                return  new ResponseBean(ResponseBean.FAILURE,"更新失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseBean(ResponseBean.FAILURE,"更新失败",null);
        }
    }

    @PostMapping("/public/selectProductByName")
    public ResponseBean selectProductByName(@RequestParam String productName){
        try{
            ResponseBean result=productService.selectProductByName(productName);
            if(result.getMsg().equals("查询成功")){
                return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",result.getData());
            }else {
                return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
        }

    }

    @PostMapping("/public/selectProductById")
    public ResponseBean selectProductById(@RequestParam int id){
        try{
            ResponseBean result=productService.selectProductById(id);
            if(result.getMsg().equals("查询成功")){
                return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",result.getData());
            }else {
                return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
        }

    }

    @PostMapping("/public/insertProduct")
    public ResponseBean insertProduct(@RequestBody Product product){
        try{
            int result=productService.insertProduct(product);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"插入成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"插入失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"插入失败",null);
        }

    }


}
