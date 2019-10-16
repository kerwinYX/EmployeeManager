package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kerwin
 * @title: CookieServlet
 * @projectName ServletDemo
 * @date 2019/10/08 - 14:25
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //Cookie的使用
        Cookie cookie = new Cookie("username","admin");
        //把cookie保存到浏览器
        resp.addCookie(cookie);
        //设置cookie的保存时间
//        cookie.setMaxAge();
        //设置cookie的路径  默认的路径就是web应用名
//        cookie.setPath("");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
