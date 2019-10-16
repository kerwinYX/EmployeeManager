package dao;

import bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kerwin
 * @title: EmployeeMapper
 * @projectName Web03456
 * @date 2019/10/10 - 20:18
 */
public interface EmployeeMapper {

    void addEmp(Employee employee);
    void deleteEmpBy(Integer id);
    List<Employee> getEmps();
    void upDateEmpById(Integer id);

    List<Employee> selectEmpsByPage(@Param("begin") Integer begin, @Param("end") Integer end);
}
