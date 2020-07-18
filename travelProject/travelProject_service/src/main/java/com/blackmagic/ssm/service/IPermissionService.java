package com.blackmagic.ssm.service;

import com.blackmagic.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(int id) throws Exception;
}
