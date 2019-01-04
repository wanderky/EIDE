package com.cy.eide.framework.util;

import com.cy.eide.framework.config.DaoConfig;
import com.cy.eide.framework.config.BeanScanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DaoConfig.class, BeanScanConfig.class})
public class DruidUtilsTest {


    @Test
    public void getDataSource() throws SQLException {
        Assert.assertNotNull(DruidUtils.getDataSource());
    }

}