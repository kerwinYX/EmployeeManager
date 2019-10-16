package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MySessionListener implements HttpSessionListener {
    //观察者模式

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //session被创建
        //servletContext：servlet上下文对象  与applicationScope一样

        //获取servletContext
        ServletContext sc = se.getSession().getServletContext();
//        System.out.println(se.getSession().getId());
        //绑定一个在线人数计算 count
        //每当创建一个session就count加1
        Object count = sc.getAttribute("count");
//        System.out.println(count);
        if (count == null ){
            //第一个用户
            sc.setAttribute("count",0);
        }else {
            sc.setAttribute("count",(Integer)count+1);
        }


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //session被销毁
        ServletContext sc = se.getSession().getServletContext();
        Object count = sc.getAttribute("count");
        sc.setAttribute("count",(Integer)count-1);
    }
}
