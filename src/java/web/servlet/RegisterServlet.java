package web.servlet;

import service.UserService;
import util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kerwin
 * @title: RegisterServlet
 * @projectName ServletDemo
 * @date 2019/10/03 - 16:42
 */
@WebServlet("/regist")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean b = UserService.registCheck(username);
        //使用md5加密密码再进行数据库持久化保存
        String digestPassword = Utils.Digest(password);

//        已经放到js里面去处理
//        if (b) {
//            //注册失败  用户名已经存在
//            //转发之前需要绑定数据  因为转发前还是一个请求对象
//            //将想要交给下一个组件处理的数据  需要绑定要request对象中
//            req.setAttribute("regist_Msg", "该用户名已经存在!");
////            获取到转发器开始转发
//            req.getRequestDispatcher("regist.jsp").forward(req, resp);
//
//        } else {

        UserService.registUser(username, digestPassword);

        resp.sendRedirect("login.jsp");
//        }

    }
}
