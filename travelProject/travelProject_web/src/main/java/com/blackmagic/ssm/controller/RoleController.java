package com.blackmagic.ssm.controller;

import com.blackmagic.ssm.domain.Permission;
import com.blackmagic.ssm.domain.Role;
import com.blackmagic.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockAsyncContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
@RequestMapping("/save.do")
    public String save(Role role)throws  Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("findById.do")
    public ModelAndView findById( String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Role role=roleService.findById(id);
        System.out.println("角色：" + role);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }
    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name="id",required = true) String roleId) throws Exception {
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        System.out.println("角色：" + role);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        System.out.println("权限：" + otherPermissions);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", otherPermissions);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }
}
