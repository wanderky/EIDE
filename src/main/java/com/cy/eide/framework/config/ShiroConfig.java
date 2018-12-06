package com.cy.eide.framework.config;


import com.cy.eide.system.organization.shiro.SysUserRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("/spring/spring-dao.xml")
@ComponentScan({"com.cy.eide.system.organization.service","com.cy.eide.system.organization.entity"})
public class ShiroConfig{
    @Bean
    SysUserRealm sysUserRealm(){
        return new SysUserRealm();
    }

    @Bean
    SecurityManager securityManager(){
        return new DefaultSecurityManager(sysUserRealm());
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    MethodInvokingFactoryBean methodInvokingFactoryBean(){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager());
        return methodInvokingFactoryBean;
    }
}
