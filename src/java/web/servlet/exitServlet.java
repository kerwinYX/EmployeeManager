package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author kerwin
 * @title: editServlet
 * @projectName Web03
 * @date 2019/10/10 - 17:21
 */
@WebServlet("/exit")
public class exitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入exitServlet");
        Cookie[] cookies = req.getCookies();
        for (Cookie c: cookies) {
            if (c.getName().equals("username")){
                System.out.println("找到"+c.getName()+"cookie");
                c.setMaxAge(0);
                System.out.println("最大时间"+c.getMaxAge());

            }
        }

        resp.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
