package cn.dust.mapper;

import cn.dust.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByName(String userName);

    List<User> getAllUsers();

    List<User> selUserByName(@Param("userName") String userName);

    int deleteUserById(int id);

    User selectUserById(int userId);

    int insertUser(User user);

    int updateUser(User user);

}
