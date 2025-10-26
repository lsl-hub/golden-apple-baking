package com.cake.controller;

import com.cake.dto.PetCakeDTO;
import com.cake.dto.PetPageQueryDTO;
import com.cake.dto.UpdatePetCakeDTO;
import com.cake.result.PageResult;
import com.cake.result.Result;
import com.cake.service.PetCakeService;
import com.cake.vo.PetVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/pet")
@RestController
@Api(tags = "宠物蛋糕相关接口")
public class PetCakeController {
    private  final PetCakeService petCakeService;

    @GetMapping("/pageQuery")
    @ApiOperation("分页查询")
    @Cacheable(value = "petCakes",key = "{#petPageQueryDTO.pageNum,#petPageQueryDTO.pageSize}")
    public Result<PageResult> PageQuery(PetPageQueryDTO petPageQueryDTO){
            PageResult pageResult =  petCakeService.PageQuery(petPageQueryDTO);
            return Result.success(pageResult);
    }

    @GetMapping("/get/{id}")
    @ApiOperation("根据宠物蛋糕id查询蛋糕信息")
    @Cacheable(value = "product",key = "#id")
    public Result<PetVO> getById(@PathVariable Long id){
        PetVO petVO = petCakeService.getById(id);
        return Result.success(petVO);
    }
    @PutMapping("/add")
    @ApiOperation("添加宠物蛋糕")
    @CacheEvict(value = "petCakes",allEntries = true)
    public Result add(@RequestBody PetCakeDTO petCakeDTO){
        petCakeService.add(petCakeDTO);
        return Result.success();
    }

    @PostMapping("/update")
    @ApiOperation("更新宠物蛋糕")
    @Caching(
            evict = {
                    @CacheEvict(value = "product",key = "#updatePetCakeDTO.id"),
                    @CacheEvict(value = "petCakes",allEntries = true)
            }
    )
    public Result update(@RequestBody UpdatePetCakeDTO updatePetCakeDTO){
        petCakeService.update(updatePetCakeDTO);
        return Result.success();
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除宠物蛋糕")
    @CacheEvict(value = "petCakes",allEntries = true)
    public Result delete(@PathVariable Long id){
        petCakeService.delete(id);
        return Result.success();
    }
}
