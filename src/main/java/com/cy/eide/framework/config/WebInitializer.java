package com.cy.eide.framework.config;

import com.cy.eide.system.organization.web.filter.UserFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /**
         *   Load Spring web application configuration
         */
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringmvcConfig.class);//注册mvc的配置类
        ctx.setServletContext(servletContext);

        /**
         * 注册自定义servlet
         */
//        ServletRegistration.Dynamic techlogServlet = servletContext.addServlet("techlogServlet", TechlogServlet.class);
//        techlogServlet.addMapping("/*");

        /**
         * 注册自定义filter
         */
//        FilterRegistration.Dynamic filter = servletContext.addFilter("techlogFilter", TechlogFilter.class);
//        filter.addMappingForUrlPatterns(null, false, "/*");


        /**
         *  注册DispatcherServlet(调度工作,控制流程)
         */
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));//配置DispatcherServlet
        servlet.addMapping("*.action");//url-pattern路径
        servlet.setLoadOnStartup(1);//启动顺序


        /**
         *  注册filter 这里是字符编码utf-8
         */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);//强制
        javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("encoding", characterEncodingFilter);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true,"*");

        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        userFilter.addMappingForUrlPatterns(null,false,"/login.action");

//        DelegatingFilterProxy delegatingFilterProxyBean = new DelegatingFilterProxy();
//        FilterRegistration.Dynamic delegatingFilterProxy = servletContext.addFilter("delegatingFilterProxy", delegatingFilterProxyBean);
//        delegatingFilterProxy.addMappingForUrlPatterns(null,false,"/login");

        javax.servlet.FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("shiroFilter", org.springframework.web.filter.DelegatingFilterProxy.class);
        shiroFilter.addMappingForUrlPatterns(null, false, "/*");
        shiroFilter.setInitParameter("targetFilterLifecycle", "true");

    }

}
