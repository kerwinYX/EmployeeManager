package web.servlet;

import bean.Employee;
import com.google.gson.Gson;
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
 * @title: getEmpsByJSON
 * @projectName ServletDemo
 * @date 2019/10/08 - 19:56
 */
@WebServlet("/getEmpsByJSON")
public class getEmpsByJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> emps = EmpService.getEmps();
        Gson gson = new Gson();
        String s = gson.toJson(emps);
        //把转换好的json字符串传出去
//        System.out.println(s);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(s);
    }
}
