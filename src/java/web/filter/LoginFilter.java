package web.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements javax.servlet.Filter {
    private String encoding;
//    private boolean loginFlag = false;

    @Override
    public void init(FilterConfig filterConfig) {
        //初始化过滤器
        encoding = filterConfig.getInitParameter("encoding");
        if (encoding == null || "".equals(encoding)) {
            encoding = "UTF-8";
        }
//        System.out.println(encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, javax.servlet.FilterChain filterChain) throws IOException, ServletException {
        //得到当前的请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String url = req.getRequestURL().toString();
//        Cookie[] cookies = req.getCookies();

//        if (url.endsWith(".jsp")){
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("username") && !url.endsWith("regist.jsp")) {
//                    req.getSession().setAttribute("username_Msg", cookie.getValue());
//                    req.getRequestDispatcher("showMsg").forward(req, resp);
//                }else {
//                    if (url.endsWith("/main.jsp")) {
//                        resp.sendRedirect("login.jsp");
//                    }
//                }
//            }
//        }


        System.out.println(url);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //销毁filter
    }
}
