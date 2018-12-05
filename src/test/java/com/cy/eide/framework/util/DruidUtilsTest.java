package com.cy.eide.framework.util;

import com.cy.eide.framework.config.DruidConfig;
import com.cy.eide.framework.config.BeanScanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DruidConfig.class, BeanScanConfig.class})
public class DruidUtilsTest {

    @Autowired
    private DruidUtils druidUtils;

    @Test
    public void getDataSource() throws SQLException {
        Assert.assertNotNull(druidUtils.getDataSource());
    }

}