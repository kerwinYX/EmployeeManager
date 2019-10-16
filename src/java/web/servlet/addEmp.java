package web.servlet;

import bean.Department;
import bean.Employee;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kerwin
 * @title: addEmp
 * @projectName Web03
 * @date 2019/10/10 - 21:37
 */
@WebServlet("/addEmp")
public class addEmp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lastName = req.getParameter("lastName");
        String emial = req.getParameter("email");
        String gender = req.getParameter("gender");
        String deptName = req.getParameter("deptName");
        Employee employee = new Employee(lastName,emial,Integer.valueOf(gender));
        Department department = new Department();
        department.setId(Integer.valueOf(deptName));
        employee.setDepartment(department);
        EmpService.addEmp(employee);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
