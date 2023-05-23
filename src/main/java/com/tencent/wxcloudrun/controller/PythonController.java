package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.Python;
import com.tencent.wxcloudrun.service.PythonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/python")
public class PythonController {
    @Resource
     private PythonService pythonService;

    @PostMapping
    public Result<?> save(@RequestBody Python python) {
        return Result.success(pythonService.save(python));
    }

    @PutMapping
    public Result<?> update(@RequestBody Python python) {
        return Result.success(pythonService.updateById(python));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        pythonService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Python> findById(@PathVariable Long id) {
        return Result.success(pythonService.getById(id));
    }

    @GetMapping
    public Result<List<Python>> findAll() {
        return Result.success(pythonService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Python>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(pythonService.page(new Page<>(pageNum, pageSize), Wrappers.<Python>lambdaQuery().like(Python::getName, name)));
    }

}