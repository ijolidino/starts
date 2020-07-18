package com.blackmagic.ssm.service;

import com.blackmagic.ssm.domain.Role;
import com.blackmagic.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;


    UserInfo findById(int id) throws Exception;

    List<Role> findOtherRoles(int userId);

    void addRoleToUser(String userId, String[] roleIds);

}
