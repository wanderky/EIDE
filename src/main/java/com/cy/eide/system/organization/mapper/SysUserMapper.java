package com.cy.eide.system.organization.mapper;

import com.cy.eide.system.organization.entity.SysUser;


public interface SysUserMapper {

    int insertUser(SysUser user);

    SysUser findUserByLoginno(String name);


}
