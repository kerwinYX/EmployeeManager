package web.servlet;

import bean.Employee;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kerwin
 * @title: PagingServlet
 * @projectName Web03
 * @date 2019/10/11 - 15:07
 */
@WebServlet("/page")
public class PagingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //当前所在页数
        int page ;
        String p = req.getParameter("page");
        try{
            page = Integer.valueOf(p);
        }catch (NumberFormatException n){
            page = 1;
        }

        List<Employee> emps = EmpService.getEmps();
        //用户总数
        int count = emps.size();
        //页面显示数
        int pageSize = 5;
        //页数
        int pageCount = count%pageSize==0 ? count/pageSize :count/pageSize+1 ;

        //当前页起始用户序号
        int beginIndex = (page-1) * pageSize+1;
        int endIndex = beginIndex + pageSize -1;


//        HttpSession session = req.getSession();
        req.setAttribute("pageCount",pageCount);

        req.setAttribute("page",page);
        List<Employee> empsByPaging = EmpService.getEmpsByPaging(beginIndex, endIndex);
//        Gson gson = new Gson();
//        String s = gson.toJson(empsByPaging);


//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().println(s);
//        System.out.println(s);
        req.setAttribute("emps", empsByPaging);

        String path = "main.jsp";
        req.getRequestDispatcher(path).forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
