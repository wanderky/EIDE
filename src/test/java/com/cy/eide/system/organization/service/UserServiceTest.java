package com.cy.eide.system.organization.service;


import com.cy.eide.framework.config.BeanScanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanScanConfig.class)
public class UserServiceTest {

    @Autowired
    SysUserService userService;

    @Test
    public void testAddUser(){
        Assert.assertNotNull(userService);
    }

}