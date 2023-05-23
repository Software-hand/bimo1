package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.Java;
import com.tencent.wxcloudrun.service.JavaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/java")
public class JavaController {
    @Resource
     private JavaService javaService;

    @PostMapping
    public Result<?> save(@RequestBody Java java) {
        return Result.success(javaService.save(java));
    }

    @PutMapping
    public Result<?> update(@RequestBody Java java) {
        return Result.success(javaService.updateById(java));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        javaService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Java> findById(@PathVariable Long id) {
        return Result.success(javaService.getById(id));
    }

    @GetMapping
    public Result<List<Java>> findAll() {
        return Result.success(javaService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Java>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(javaService.page(new Page<>(pageNum, pageSize), Wrappers.<Java>lambdaQuery().like(Java::getName, name)));
    }

}