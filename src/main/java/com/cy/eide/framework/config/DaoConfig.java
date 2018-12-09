package com.cy.eide.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * spring DAO层配置
 */
@Configuration
@ImportResource({"classpath:/spring/spring-dao.xml"})
public class DaoConfig {

}
