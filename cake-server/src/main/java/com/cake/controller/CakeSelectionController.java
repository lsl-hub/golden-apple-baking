package com.cake.controller;

import com.cake.dto.CakeDTO;
import com.cake.dto.CakePageQueryDTO;
import com.cake.exception.ProductAlreadyExists;
import com.cake.result.PageResult;
import com.cake.result.Result;
import com.cake.service.CakeSelectionService;
import com.cake.vo.CakeVO;
import com.cake.vo.TasteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cakes")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "蛋糕甄选相关接口")
public class CakeSelectionController {
    private final CakeSelectionService cakeSelectionService;

    @GetMapping("/list")
    @ApiOperation("分页查询")
    @Cacheable(value = "cakeSelection",key = "{#cakePageQueryDTO.tasteId,#cakePageQueryDTO.number}")
    public Result<PageResult> pageQuery( CakePageQueryDTO cakePageQueryDTO){
        PageResult pageQuery= cakeSelectionService.pageQuery(cakePageQueryDTO);
        log.info("蛋糕信息：{}",pageQuery);
        return Result.success(pageQuery);
    }

    @PostMapping("/add")
    @ApiOperation("添加蛋糕")
    @CacheEvict(value = "cakeSelection",allEntries = true)
    public Result add(@RequestBody CakeDTO cakeDTO) throws ProductAlreadyExists {
        cakeSelectionService.add(cakeDTO);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("根据蛋糕id获得蛋糕详情")
    @Cacheable(value = "product",key = "#id")
    public Result<CakeVO> getById(@PathVariable Long id) {
        CakeVO cakeVO = cakeSelectionService.getById(id);
        return Result.success(cakeVO);
    }

    @PutMapping("/update")
    @ApiOperation("修改蛋糕信息")
    @Caching(
            evict = {
                    @CacheEvict(value = "product",key = "#cakeDTO.id"),
                    @CacheEvict(value = "cakeSelection",allEntries = true)
            }
    )
    public Result update(@RequestBody CakeDTO cakeDTO){
        cakeSelectionService.update(cakeDTO);
        return Result.success();

    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除蛋糕")
    @CacheEvict(value = "cakeSelection",allEntries = true)
    public Result delete(@PathVariable Long id){
        cakeSelectionService.delete(id);
        return Result.success();
    }

    @GetMapping("/taste/list")
    @ApiOperation("获得口味列表")
    @Cacheable(value = "tastes")
    public Result<List<TasteVO>> getTasteList(){
        List<TasteVO> tasteVOList = cakeSelectionService.getTasteList();
        return Result.success(tasteVOList);
    }
}
