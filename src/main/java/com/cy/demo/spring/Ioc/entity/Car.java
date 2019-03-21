package com.cy.demo.spring.Ioc.entity;

/**
 * @ProjectName: eide
 * @Package: com.cy.demo.spring.Ioc.entity
 * @ClassName: Car
 * @Author: wander
 * @Description: car
 * @Date: 2019/3/19 23:11
 * @Version: 1.0
 */

public class Car {
    private String name;
    private String id;
    private String sumary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }
}
