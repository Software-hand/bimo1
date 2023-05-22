package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.RoleMapper;
import com.tencent.wxcloudrun.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    @Resource
    private RoleMapper roleMapper;

}
