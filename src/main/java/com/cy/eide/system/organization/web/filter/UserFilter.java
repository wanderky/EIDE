package com.cy.eide.system.organization.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入自定义filter中");

        System.out.println("开始处理业务");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
