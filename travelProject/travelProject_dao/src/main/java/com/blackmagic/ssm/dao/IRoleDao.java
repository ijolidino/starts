package com.blackmagic.ssm.dao;

import com.blackmagic.ssm.domain.Permission;
import com.blackmagic.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from user_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.blackmagic.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id in (select roleId from role_permission where roleId=#{roleId})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property ="roleName",column = "roleName"),
            @Result(property ="roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.blackmagic.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String id) throws Exception;

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

}
