package com.blackmagic.ssm.service.impl;

import com.blackmagic.ssm.dao.IRoleDao;
import com.blackmagic.ssm.domain.Permission;
import com.blackmagic.ssm.domain.Role;
import com.blackmagic.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception{
        iRoleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return iRoleDao.findById(id);
    }

    @Override
    public void deleteRoleById(String roleId) {
        iRoleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return iRoleDao.findOtherPermissions(roleId);
    }
}
