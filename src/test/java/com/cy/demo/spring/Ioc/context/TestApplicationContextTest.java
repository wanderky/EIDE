package com.cy.demo.spring.Ioc.context;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestApplicationContextTest {


    @Test
    public void getCar() {
        TestApplicationContext testApplicationContext = new TestApplicationContext();
        Assert.assertNotNull(testApplicationContext.getCar());
    }
}