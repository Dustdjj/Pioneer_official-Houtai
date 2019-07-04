package cn.dust.controller;

import cn.dust.domain.ResponseBean;
import cn.dust.domain.User;
import cn.dust.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("public/selUserByName")
    public ResponseBean selUserByName(@RequestParam("userName") String userName){
        try{
            ResponseBean result=userService.selUserByName(userName);
            if(result.getMsg().equals("搜索成功")){
                return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",result.getData());
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"搜索失败",null);
        }
    }

    @PostMapping("/public/updateUserById")
    public ResponseBean updateProductById(@RequestBody User user){
        try {
            int result=userService.update(user);
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

    @PostMapping("/public/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password")String password) {
        try{
            System.out.println(username+"  "+password);

            ResponseBean result = userService.Login(username,password);

            if(result.getMsg().equals("登录成功")){
                return new ResponseBean(ResponseBean.SUCCESS, "登录成功",result.getData());
            }else {
                return new ResponseBean(ResponseBean.FAILURE,"登录失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"登录失败",null);

        }

    }

    @PostMapping("/public/getAllUsers")
    public ResponseBean getAllUsers(@Param("page") int page){
        ResponseBean result = userService.getAllUsers(page);
        if(result.getMsg().equals("查询成功")) {
            return new ResponseBean(ResponseBean.SUCCESS,"查询成功",result.getData());
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"查询失败",null);
        }
    }

    @PostMapping("/public/createUser")
    public ResponseBean createUser(@RequestBody User user){
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setUserPassword(user.getUserPassword());
        int result = userService.insertUser(user1);
        if(result > 0 ){
            return new ResponseBean(ResponseBean.SUCCESS,"创建成功",null);
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"创建失败",null);
        }
    }

    @PostMapping("/public/deleteUserById")
    public ResponseBean deleteTecById(@RequestParam int userId){
        try{
            int result=userService.deleteUserById(userId);
            if(result>0){
                return new ResponseBean(ResponseBean.SUCCESS,"删除成功",null);
            }else{
                return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE,"删除失败",null);
        }
    }

}
