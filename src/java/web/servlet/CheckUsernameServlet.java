package web.servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kerwin
 * @title: CheckUsernameServlet
 * @projectName ServletDemo
 * @date 2019/10/03 - 20:04
 */
@WebServlet("/CheckUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = UserService.registCheck(username.replace(" ",""));
        String msg;
        if (b) {
            msg = "0";
        } else{
            msg = "1";
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(msg);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.doGet(req,resp);
    }
}

