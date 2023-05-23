package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.tencent.wxcloudrun.dao.PythonMapper;
import com.tencent.wxcloudrun.entity.Python;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PythonService extends ServiceImpl<PythonMapper, Python> {

    @Resource
    private PythonMapper pythonMapper;

}