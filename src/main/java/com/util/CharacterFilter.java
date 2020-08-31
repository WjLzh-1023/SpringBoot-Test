package com.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharacterFilter implements Filter {

    public CharacterFilter() {
        System.out.println("CharacterFilter构造器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CharacterFilter，doFilter方法");
        //字符集设置
        //处理服务端到客户端乱码
        response.setContentType("text/html;charset=utf-8");
        //处理客户端到服务端乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");

        //禁止浏览器缓存页面
        HttpServletResponse resp = (HttpServletResponse) response;
        //Pragma用来包含实现特定的指令，将它设置为“no-cache”；
        resp.setHeader("Pragma","no-cache");
        //Cache-Control属性指定请求和响应的缓存机制，将它设置为no-cache
        resp.setHeader("Cache-Control","no-cache");
        //Expires设置过期的时间期限,-1缓存已经过期
        resp.setDateHeader("Expires", -1);

        //正常放行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("CharacterFilter销毁了");
    }
}
