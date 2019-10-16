package web.servlet;
import bean.Employee;
import service.EmpService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kerwin
 * @title: showMsg
 * @projectName Web
 * @date 2019/10/09 - 15:48
 */
@WebServlet("/showMsg")
public class showMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询数据
        List<Employee> emps = EmpService.getEmps();

        //发送查询到的员工数据
        req.setAttribute("emps",emps);
        req.getRequestDispatcher("main.jsp").forward(req,resp);

//        resp.sendRedirect("main.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
