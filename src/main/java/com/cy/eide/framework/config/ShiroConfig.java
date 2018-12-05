package com.cy.eide.framework.config;

import com.cy.eide.system.organization.shiro.SysUserRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource({"classpath:/spring/spring-dao.xml","classpath:/spring/spring-service.xml"})
public class ShiroConfig {



    @Bean
    public SysUserRealm getSysUserRealm(){
        return new SysUserRealm();
    }

    @Bean
    public SecurityManager getSecurityManager(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(getSysUserRealm());
        return securityManager;
    }

}
