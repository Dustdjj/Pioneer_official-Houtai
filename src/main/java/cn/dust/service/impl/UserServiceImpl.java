package cn.dust.service.impl;

import cn.dust.domain.ResponseBean;
import cn.dust.domain.User;
import cn.dust.mapper.UserMapper;
import cn.dust.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        try {
            System.out.println(userMapper.getUserByName(userName));
            User user = userMapper.getUserByName(userName);
            return userMapper.getUserByName(userName);
        }catch (RuntimeException r){
            r.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseBean selUserByName(String userName) {
        List<User>list=userMapper.selUserByName(userName);
        return new ResponseBean(ResponseBean.SUCCESS,"搜索成功",list);
    }

    @Override
    public ResponseBean getAllUsers(int page) {
        PageHelper.startPage(page, 10);
        List<User> users = userMapper.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return new ResponseBean(ResponseBean.SUCCESS,"查询成功",pageInfo);
    }

    @Override
    public ResponseBean Login(String username, String password) {
        User user=userMapper.getUserByName(username);
        try{
            if(user.getUserPassword().equals(password)){
                return new ResponseBean(ResponseBean.SUCCESS, "登录成功", user);
            }else{
                return new ResponseBean(ResponseBean.FAILURE, "密码错误", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(ResponseBean.FAILURE, "密码错误", null);
        }

    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateUser(user);
    }
}
