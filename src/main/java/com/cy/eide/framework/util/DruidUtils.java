package com.cy.eide.framework.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * DruidDataSource工具类，获取数据源
 */

@Component
public class DruidUtils {

    private static DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        DruidUtils.dataSource = dataSource;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
