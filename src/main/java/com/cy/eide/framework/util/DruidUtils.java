package com.cy.eide.framework.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DruidUtils {

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource(){
        return dataSource;
    }

}
