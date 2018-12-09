package com.cy.eide.system.organization.service;

import com.cy.eide.system.organization.entity.SysUser;

public interface SysUserService {
    public int insertUser(SysUser user);

    public SysUser findUserByLoginno(String name);

    public void login(String username, String password);
}
