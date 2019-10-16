package dao;

import bean.Employee;
import bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author kerwin
 * @title: UserMapper
 * @projectName ServletDemo
 * @date 2019/09/30 - 12:14
 */
public interface UserMapper {

    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String Password);
    List<String> getUsernameList();
    void insertUser(@Param("username") String username, @Param("password") String Password);


}
