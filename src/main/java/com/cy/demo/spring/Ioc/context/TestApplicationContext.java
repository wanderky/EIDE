package com.cy.demo.spring.Ioc.context;

import com.cy.demo.spring.Ioc.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: eide
 * @Package: com.cy.demo.spring.Ioc.context
 * @ClassName: TestApplicationContext
 * @Author: wander
 * @Description:
 * @Date: 2019/3/19 23:13
 * @Version: 1.0
 */

public class TestApplicationContext {
    public static ApplicationContext getContext(){
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public Car getCar(){
        return (Car) getContext().getBean("car");
    }
}
