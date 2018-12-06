package com.cy.eide.framework.config;

import com.cy.eide.framework.util.DruidUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan({"com.cy.eide.system.organization.entity","com.cy.eide.system.organization.service","com.cy.eide.system.organization.shiro"})
public class BeanScanConfig {

}
