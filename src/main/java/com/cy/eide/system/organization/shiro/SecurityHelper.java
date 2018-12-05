package com.cy.eide.system.organization.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class SecurityHelper {

    static {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new SysUserRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
    }

    /**
     * SecurityHelper用来配置shiro的Realm
     * @return
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

}
