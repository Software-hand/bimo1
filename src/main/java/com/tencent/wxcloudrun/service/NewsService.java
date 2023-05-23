package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tencent.wxcloudrun.dao.NewsMapper;
import com.tencent.wxcloudrun.entity.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

    @Resource
    private NewsMapper newsMapper;

}