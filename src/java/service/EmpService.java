package service;

import bean.Employee;
import dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

import static util.Utils.getSqlSessionFactory;

/**
 * @author kerwin
 * @title: EmpService
 * @projectName Web03
 * @date 2019/10/10 - 23:05
 */
public class EmpService {

    public static List<Employee> getEmps() throws IOException {
        EmployeeMapper mapper = getSqlSessionFactory().openSession().getMapper(EmployeeMapper.class);
        return mapper.getEmps();
    }

    public static void addEmp(Employee employee) throws IOException {

        SqlSession session = getSqlSessionFactory().openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.addEmp(employee);
        session.commit();
        session.close();
    }

    public static List<Employee> getEmpsByPaging(Integer begin,Integer end) throws IOException {
        EmployeeMapper mapper = getSqlSessionFactory().openSession().getMapper(EmployeeMapper.class);


        return mapper.selectEmpsByPage(begin, end);
    }

    public static void deleteEmp(Integer id) throws IOException {

        SqlSession session = getSqlSessionFactory().openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.deleteEmpBy(id);
        session.commit();
        session.close();
    }
}
