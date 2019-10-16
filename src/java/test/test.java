package test;

import bean.Department;
import bean.Employee;
import bean.User;
import com.google.gson.Gson;
import dao.EmployeeMapper;
import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import service.EmpService;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * @author kerwin
 * @title: test
 * @projectName ServletDemo
 * @date 2019/09/30 - 13:45
 */
public class test {
    /**
    * 验证数据库里有没有该用户，以及密码是否正确
    * */
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User userByUsernameAndPassword = mapper.getUserByUsernameAndPassword("admin", "kerwin");
        System.out.println(userByUsernameAndPassword);

    }





    /**
    * 找出数据库中所有的用户名并保存在一个list中
    * */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        List<String> usernameList = mapper.getUsernameList();
        System.out.println(usernameList);
        System.out.println(usernameList.contains(" 张子  枫 ".replace(" ","")));
        System.out.println(" 张子  枫 ".trim());
    }



    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * MD5加密
     * */
    @Test
    public void testMd5() throws NoSuchAlgorithmException {
        String str = "1219";
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.update(str.getBytes());
        System.out.println(new BigInteger(1, md5.digest()).toString(16));

    }


    @Test
    public void testGetEmps() throws IOException {
        List<Employee> emps = EmpService.getEmps();
        System.out.println(emps);
        System.out.println(emps.get(1).getDepartment());

    }


    @Test
    public void testPaging() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
////        SqlSession session = sqlSessionFactory.openSession();
////        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
////        List<Employee> employees = mapper.selectEmpsByPage(1, 6);
////        System.out.println(employees);

        List<Employee> empsByPaging = EmpService.getEmpsByPaging(6, 10);
        System.out.println(empsByPaging);

    }



    @Test
    public void testJSONtoJAVA(){
        Gson gson = new Gson();
        //JSON字符串转换成java对象
        String jsonStr = "{\"id\":1001,\"deptName\":\"销售部\"}";
        Map map = gson.fromJson(jsonStr, Map.class);
        System.out.println(map);

        Department department = gson.fromJson(jsonStr, Department.class);
        System.out.println(department);

    }
//
//    @Test
//    public void testJAVAtoJSON() throws IOException {
//        Department department = new Department("销售部",11);
//        Employee employee = new Employee(11,"KERWIN","KERWIN@QQ.COM",0);
//        employee.setDepartment(department);
//
//        Gson gson = new Gson();
//        String s = gson.toJson(employee);
//        System.out.println(s);
//
//        System.out.println("--------------");
//        //也可以输出一个集合
//        List<Employee> emps = EmpService.getEmps();
//
//        String s1 = gson.toJson(emps);
//        System.out.println(s1);
//    }


    @Test
    public void testMySQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<String> usernameList = mapper.getUsernameList();
        System.out.println(usernameList);

    }
}
