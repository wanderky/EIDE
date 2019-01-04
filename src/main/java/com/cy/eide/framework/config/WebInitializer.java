package com.cy.eide.framework.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
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
         *  注册DispatcherServlet(调度工作,控制流程)
         */
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));//配置DispatcherServlet
        servlet.addMapping("/");//url-pattern路径
        servlet.setLoadOnStartup(1);//启动顺序




        /**
         *  注册filter 这里是字符编码utf-8
         */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);//强制
        javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("encoding", characterEncodingFilter);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true,"*");

        /**
         * load shiro  org.apache.shiro.spring.web.ShiroFilterFactoryBean
         */
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setBeanName("shiroFilter");
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        javax.servlet.FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("shiroFilter", delegatingFilterProxy);
        shiroFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }

}
