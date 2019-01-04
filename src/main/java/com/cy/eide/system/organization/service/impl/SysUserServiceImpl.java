package com.cy.eide.system.organization.service.impl;


import com.cy.eide.system.organization.entity.SysUser;
import com.cy.eide.system.organization.mapper.SysUserMapper;
import com.cy.eide.system.organization.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public int insertUser(SysUser user) {
        int rows = sysUserMapper.insertUser(user);
        return rows;
    }

    public SysUser findUserByLoginno(String name) {
        return sysUserMapper.findUserByLoginno(name);
    }

    public void login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
        } catch (UnknownAccountException e){
            e.printStackTrace();
        }
    }
}
