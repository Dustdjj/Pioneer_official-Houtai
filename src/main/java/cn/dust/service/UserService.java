package cn.dust.service;


import cn.dust.domain.ResponseBean;
import cn.dust.domain.User;

public interface UserService{
    User getUserByName(String userName);

    ResponseBean selUserByName(String userName);

    ResponseBean getAllUsers(int page);

    ResponseBean Login(String username, String password);

    int deleteUserById(int id);

    int insertUser(User user);

    int update(User user);


}
