package com.cake.controller;

import com.cake.dto.ProductDTO;
import com.cake.entity.Product;
import com.cake.result.Result;
import com.cake.service.SearchProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
@Api(tags = "搜索相关接口")
@Slf4j
public class SearchProductController {
    private final SearchProductService searchProductService;

    @GetMapping("/{name}")
    @ApiOperation("搜索商品")
    public Result<List<Product>> searchProduct(@PathVariable String name){
        log.info("搜索商品信息:{}",name);
        List<Product> productList = searchProductService.searchProduct(name);
        return Result.success(productList);
    }

    @PostMapping("/update")
    @ApiOperation("更新商品")
    public Result update(@RequestBody ProductDTO productDTO){
        searchProductService.update(productDTO);
        return Result.success();
    }

}
