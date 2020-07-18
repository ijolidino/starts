package com.blackmagic.ssm.service.impl;

import com.blackmagic.ssm.dao.IPermissionDao;
import com.blackmagic.ssm.domain.Permission;
import com.blackmagic.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IPermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao iPermissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        Integer permissionId = (int) (Math.random() * Math.random() * Math.random() * 100000);
        permission.setId(permissionId.toString());
        iPermissionDao.save(permission);
    }

    @Override
    public Permission findById(int id) throws Exception {
        return iPermissionDao.findById(id);
    }
}
