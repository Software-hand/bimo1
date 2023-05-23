package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.Lists;
import com.tencent.wxcloudrun.service.ListsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListsController {
    @Resource
    private ListsService listsService;

    // 默认请求方法为GET
    @RequestMapping
    public Result<List<Lists>> findAll() {
        return Result.success(listsService.list());
    }

    // 请求方法为POST，保存列表信息
    @PostMapping
    public Result<?> save(@RequestBody Lists lists) {
        return Result.success(listsService.save(lists));
    }

    // 请求方法为PUT，更新列表信息
    @PutMapping
    public Result<?> update(@RequestBody Lists lists) {
        return Result.success(listsService.updateById(lists));
    }

    // 请求方法为DELETE，删除列表信息
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        listsService.removeById(id);
        return Result.success();
    }

    // 请求方法为GET，根据ID查找列表信息
    @GetMapping("/{id}")
    public Result<Lists> findById(@PathVariable Long id) {
        return Result.success(listsService.getById(id));
    }

    // 请求方法为GET，分页查询列表信息
    @GetMapping("/page")
    public Result<IPage<Lists>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        // 使用MyBatis Plus提供的分页查询方法，进行模糊查询
        return Result.success(listsService.page(new Page<>(pageNum, pageSize), Wrappers.<Lists>lambdaQuery().like(Lists::getName, name)));
    }

}