package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.SysUser;
import com.springboot.mybatis.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping(value = "/sysUsers", method = RequestMethod.GET)
    public List<SysUser> selectAll() {
        return sysUserService.selectAll();
    }

    @RequestMapping(value = "/sysUser/{id}", method = RequestMethod.GET)
    public SysUser getOne(@PathVariable("id") long id) {
        return sysUserService.getOne(id);
    }

    @RequestMapping(value = "/sysUser/{id}", method = RequestMethod.DELETE)
    public void deleteSysUser(@PathVariable("id") long id) {
        sysUserService.delete(id);
    }

    @RequestMapping(value = "/sysUser", method = RequestMethod.POST)
    public void addSysUser(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
    }

    @RequestMapping(value = "/sysUser", method = RequestMethod.PUT)
    public void updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
    }
}
