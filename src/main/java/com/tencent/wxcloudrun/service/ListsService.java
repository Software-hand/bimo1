package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tencent.wxcloudrun.dao.ListsMapper;
import com.tencent.wxcloudrun.entity.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ListsService extends ServiceImpl<ListsMapper, Lists> {

    @Resource
    private ListsMapper listsMapper;

}