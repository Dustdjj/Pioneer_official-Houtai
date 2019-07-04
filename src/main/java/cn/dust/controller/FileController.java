package cn.dust.controller;

import cn.dust.domain.News;
import cn.dust.domain.Product;
import cn.dust.domain.ResponseBean;
import cn.dust.domain.Technology;
import cn.dust.service.NewsService;
import cn.dust.service.ProductService;
import cn.dust.service.TecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@RestController
public class FileController {

    @Value("${com.sxito.custom.windows-path}")
    private String windowsuploadPathNews;

    @Value("${com.sxito.custom.linux-path}")
    private String linuxuploadPathNews;

    @Value("${com.sxito.custom.windows-backupPath}")
    private String windowsuploadPathTec;

    @Value("${com.sxito.custom.linux-backupPath}")
    private String linuxuploadPathTec;

    @Value("${com.sxito.custom.windows-productpath}")
    private String windowsuploadPathProduct;

    @Value("${com.sxito.custom.linux-productpath}")
    private String linuxuploadPathProuduct;

    @Autowired
    private ProductService productService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private TecService tecService;

    @RequestMapping(value="/public/uploadNewsImg",method = RequestMethod.POST)
    public ResponseBean uploadNewsImg(@RequestParam MultipartFile file, @RequestParam String newsTitle, @RequestParam String newsContent, @RequestParam String newsImg) {
        String upload = null;
        upload = getPathNews();
        if (Objects.isNull(file) || file.isEmpty()) {
            return new ResponseBean(ResponseBean.FAILURE, "文件为空,请重新上传", null);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload + file.getOriginalFilename());
            if (!Files.isWritable(path)) {//判断文件夹
                Files.createDirectories(Paths.get(upload));//不存在就新建
            }
            Files.write(path, bytes);
            News news=new News();
            news.setNewsTitle(newsTitle);
            news.setNewsContent(newsContent);
            news.setNewsImg(newsImg);
            int result=newsService.insertNews(news);
            if(result > 0){
                return new ResponseBean(ResponseBean.SUCCESS,"上传成功",null);
            }else {
                return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
        }
    }

    @RequestMapping(value="/public/uploadTecImg",method = RequestMethod.POST)
    public ResponseBean uploadTecImg(@RequestParam MultipartFile file, @RequestParam String tecTitle, @RequestParam String tecContent, @RequestParam String tecImg) {
        String upload = null;
        upload = getPathTec();
        if (Objects.isNull(file) || file.isEmpty()) {
            return new ResponseBean(ResponseBean.FAILURE, "文件为空,请重新上传", null);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload + file.getOriginalFilename());
            if (!Files.isWritable(path)) {//判断文件夹
                Files.createDirectories(Paths.get(upload));//不存在就新建
            }
            Files.write(path, bytes);
            Technology tec=new Technology();
            tec.setTecTitle(tecTitle);
            tec.setTecContent(tecContent);
            tec.setTecImg(tecImg);
            int result=tecService.insertTec(tec);
            if(result > 0){
                return new ResponseBean(ResponseBean.SUCCESS,"上传成功",null);
            }else {
                return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
        }
    }

    @RequestMapping(value="/public/uploadProductImg",method = RequestMethod.POST)
    public ResponseBean uploadProductImg(@RequestParam MultipartFile file, @RequestParam String productName, @RequestParam String productDescription, @RequestParam String productImg) {
        String upload = null;
        upload = getPathProduct();
        if (Objects.isNull(file) || file.isEmpty()) {
            return new ResponseBean(ResponseBean.FAILURE, "文件为空,请重新上传", null);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload + file.getOriginalFilename());
            if (!Files.isWritable(path)) {//判断文件夹
                Files.createDirectories(Paths.get(upload));//不存在就新建
            }
            Files.write(path, bytes);
            Product product=new Product();
            product.setProductName(productName);
            product.setProductDescription(productDescription);
            product.setProductImg(productImg);
            int result=productService.insertProduct(product);
            if(result > 0){
                return new ResponseBean(ResponseBean.SUCCESS,"上传成功",null);
            }else {
                return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE, "上传失败", null);
        }
    }

    public String getPathNews(){
        String path = null;
        if(System.getProperty("os.name").indexOf("Windows") != -1){
            path = windowsuploadPathNews;
        }else {
            path = linuxuploadPathNews;
        }
        return path;
    }

    public String getPathTec(){
        String path = null;
        if(System.getProperty("os.name").indexOf("Windows") != -1){
            path = windowsuploadPathTec;
        }else {
            path = linuxuploadPathTec;
        }
        return path;
    }

    public String getPathProduct(){
        String path = null;
        if(System.getProperty("os.name").indexOf("Windows") != -1){
            path = windowsuploadPathProduct;
        }else {
            path = linuxuploadPathProuduct;
        }
        return path;
    }

}
