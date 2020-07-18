package com.blackmagic.ssm.dao;

import com.blackmagic.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from Permission")
    List<Permission> findAll() throws Exception;

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    List<Permission> findPermissionByRoleId(int id) throws Exception;
    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id =#{id}")
    Permission findById(int id) throws Exception;
}
