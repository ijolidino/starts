package com.blackmagic.ssm.service;

import com.blackmagic.ssm.domain.Permission;
import com.blackmagic.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll() throws Exception;


    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void deleteRoleById(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

    List<Permission> findOtherPermissions(String roleId);
}
