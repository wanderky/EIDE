package com.cy.eide.framework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring自动注入配置扫描路径
 */
@Configuration
@ComponentScan({"com.cy.eide.system.organization.entity","com.cy.eide.framework.util", "com.cy.eide.system.organization.web.controller","com.cy.eide.system.organization.service", "com.cy.eide.system.organization.shiro"})
public class BeanScanConfig {
	
}
