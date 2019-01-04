package com.cy.eide.framework.config;


import com.cy.eide.system.organization.shiro.SysUserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化shiro securityUtils到spring容器
 */

@Configuration
public class ShiroConfig {

    /**
     * 配置自定义Realm
     *
     * @return
     */
    @Bean
    SysUserRealm sysUserRealm() {
        return new SysUserRealm();
    }

    /**
     * 注入自定义Realm到DefaultSecurityManager
     *
     * @return
     */

    @Bean
    SecurityManager securityManager() {
        return new DefaultWebSecurityManager(sysUserRealm());
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 注入DefaultSecurityManager到securityUtils
     *
     * @return
     */
    @Bean
    MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager());
        return methodInvokingFactoryBean;
    }

    @Bean(name = "shiroFilter" )
    ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setFilterChainDefinitions("/index.jsp = user");
        shiroFilterFactoryBean.setLoginUrl("/login.action");
        shiroFilterFactoryBean.setSuccessUrl("/first.action");
        shiroFilterFactoryBean.setUnauthorizedUrl("/refuse.jsp");
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        return shiroFilterFactoryBean;
    }
}
