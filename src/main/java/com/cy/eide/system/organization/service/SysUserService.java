package com.cy.eide.system.organization.service;

import com.cy.eide.system.organization.entity.SysUser;

public interface SysUserService {
     int insertUser(SysUser user);

     SysUser findUserByLoginno(String name);

     void login(String username, String password);
}
