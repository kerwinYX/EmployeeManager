package service;

import bean.Employee;
import bean.User;
import dao.EmployeeMapper;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.IOException;
import java.util.List;
import static util.Utils.getSqlSessionFactory;

/**
 * @author kerwin
 * @title: getUser
 * @projectName ServletDemo
 * @date 2019/09/30 - 14:57
 */
public class UserService {

    public static boolean loginCheck(String username, String password) throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        User user;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            user = mapper.getUserByUsernameAndPassword(username, password);
            return user != null;
        }

    }

    public static boolean registCheck(String username) throws IOException {

        UserMapper mapper = getSqlSessionFactory().openSession().getMapper(UserMapper.class);
        List<String> usernameList = mapper.getUsernameList();
        System.out.println(usernameList);
        return usernameList.contains(username);
    }

    public static void registUser(String username,String password) throws IOException {
        SqlSession session = getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(username,password);
        session.commit();
        session.close();
    }








}

