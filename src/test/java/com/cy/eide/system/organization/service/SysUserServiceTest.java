package com.cy.eide.system.organization.service;

import com.cy.eide.framework.config.BeanScanConfig;
import com.cy.eide.framework.config.DruidConfig;
import com.cy.eide.framework.config.ShiroConfig;
import com.cy.eide.framework.config.WebConfig;
import com.cy.eide.system.organization.entity.SysUser;
import com.cy.eide.system.organization.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DruidConfig.class,BeanScanConfig.class,ShiroConfig.class})
public class SysUserServiceTest {

    @Autowired
    SysUser sysUser;

    @Autowired
    SysUserService sysUserService;

    @Test
    public void insertUser() {
        String id = UUID.randomUUID().toString();
        sysUser.setId(id);
        sysUser.setName("wander");
        sysUser.setLoginno("wander");
        sysUser.setLoginpwd("123456");
        sysUserService.insertUser(sysUser);
    }

    @Test
    public void findUserByLoginno() {
        String username = "wander";
        SysUser sysUser1 = sysUserService.findUserByLoginno(username);
        System.out.println(sysUser1.getLoginpwd());
    }

    @Test
    public void login() {
        String username = "wander";
        String password = "123456";
        sysUserService.login(username,password);
    }
}