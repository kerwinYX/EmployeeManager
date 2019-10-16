package web.servlet;

import service.UserService;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * 处理登陆请求
 */
@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

//        Cookie[] cookies = req.getCookies();

        //获取到用户输入的用户名密码  实现登陆
//        System.out.println("-----------------------");
        //请求编码设置需要在获取数据之前设置
        req.setCharacterEncoding("UTF-8");
        //获取用户名
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        运行Md5
        String digest = Utils.Digest(password);

//        System.out.println(username + ":" + password);

        //响应编码设置需要在相应之前设置
        resp.setContentType("text/html;charset=UTF-8");
        boolean b = UserService.loginCheck(username, digest);
//        System.out.println(username);
        if (b) {
            //将用户信息设置到session中

            HttpSession session = req.getSession();
            session.setAttribute("username_Msg", username);

            Cookie cookie = new Cookie("username", username);
//            javax.servlet.http.Cookie cookieAuto = new javax.servlet.http.Cookie("AutoLogin", "login");
            resp.addCookie(cookie);
//            resp.addCookie(cookieAuto);
            cookie.setMaxAge( 60 * 60);
//            cookieAuto.setMaxAge(24 * 60 * 60);
            System.out.println("最大时间"+cookie.getMaxAge());

            req.getRequestDispatcher("page").forward(req, resp);

        } else {
            //妆发之前需要绑定数据  因为转发前还是一个请求对象
            //将想要交给下一个组件处理的数据  需要绑定要request对象中
            req.setAttribute("login_Msg", "用户名或密码错误");
//            获取到转发器
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
//            开始转发
            requestDispatcher.forward(req, resp);

        }

    }
}
