package bean;

import java.util.List;

/**
 * @author kerwin
 * @title: Department
 * @projectName ServletDemo
 * @date 2019/10/08 - 15:16
 */
public class Department {
    private Integer id;
    private String deptName;
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department() {
    }

    public Department(String deptName, Integer id) {
        this.deptName = deptName;
        this.id = id;
    }
}
