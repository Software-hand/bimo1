package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.News;
import com.tencent.wxcloudrun.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
     private NewsService newsService;

    @PostMapping
    public Result<?> save(@RequestBody News news) {
        return Result.success(newsService.save(news));
    }

    @PutMapping
    public Result<?> update(@RequestBody News news) {
        return Result.success(newsService.updateById(news));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        newsService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<News> findById(@PathVariable Long id) {
        return Result.success(newsService.getById(id));
    }

    @GetMapping
    public Result<List<News>> findAll() {
        return Result.success(newsService.list());
    }

    @GetMapping("/page")
    public Result<IPage<News>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(newsService.page(new Page<>(pageNum, pageSize), Wrappers.<News>lambdaQuery().like(News::getName, name)));
    }

}