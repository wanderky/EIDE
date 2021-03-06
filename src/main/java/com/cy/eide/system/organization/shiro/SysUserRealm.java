package com.cy.eide.system.organization.shiro;

import com.cy.eide.system.organization.entity.SysUser;
import com.cy.eide.system.organization.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser sysUser = sysUserService.findUserByLoginno(username);
        if(sysUser == null){
            throw new UnknownAccountException();
        }
        if(sysUser.getLockflag() == 0){
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser.getName(), sysUser.getLoginpwd(),getName());
        return simpleAuthenticationInfo;
    }
}

