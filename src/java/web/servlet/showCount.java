package web.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/showCount")
public class showCount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req,resp);
        int count = (int) req.getSession().getServletContext().getAttribute("count");
//        Cookie cookie = new Cookie("count", (String) count);
        resp.getWriter().println(count);
    }
}
