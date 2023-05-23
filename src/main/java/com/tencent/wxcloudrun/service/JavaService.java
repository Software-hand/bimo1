package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tencent.wxcloudrun.dao.JavaMapper;
import com.tencent.wxcloudrun.entity.Java;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaService extends ServiceImpl<JavaMapper, Java> {

    @Resource
    private JavaMapper javaMapper;

}