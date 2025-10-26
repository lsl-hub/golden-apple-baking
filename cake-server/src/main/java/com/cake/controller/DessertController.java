package com.cake.controller;

import com.cake.dto.DessertDTO;
import com.cake.dto.DessertPageQueryDTO;
import com.cake.result.PageResult;
import com.cake.result.Result;
import com.cake.service.DessertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/desserts")
@Slf4j
@Api(tags = "甜品相关接口")
public class DessertController {
    private final DessertService dessertService;

    @PutMapping("/add")
    @ApiOperation("添加甜品")
    public Result add(@RequestBody DessertDTO dessertDTO){
        dessertService.add(dessertDTO);
        return Result.success();

    }

    @GetMapping("/list")
    @ApiOperation("获得所有甜品")
    @Cacheable(value = "desserts",key = "{#dessertPageQueryDTO.pageNum,#dessertPageQueryDTO.pageSize}")
    public Result<PageResult> list( DessertPageQueryDTO dessertPageQueryDTO){
        PageResult pageQuery  = dessertService.pageQuery(dessertPageQueryDTO);
        return  Result.success(pageQuery);

    }

    @PostMapping("/update")
    @ApiOperation("更新甜品")
    @Caching(
            evict = {
                    @CacheEvict(value = "product",key = "#dessertDTO.id"),
                    @CacheEvict(value = "desserts",allEntries = true)
            }
    )
    public Result update(@RequestBody DessertDTO dessertDTO){
        dessertService.update(dessertDTO);
        return Result.success();

    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除甜品")
    @CacheEvict(value = "desserts",allEntries = true)
    public Result delete(@PathVariable Long id){
        dessertService.delete(id);
        return Result.success();

    }
}
