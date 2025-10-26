package com.cake.controller;

import com.cake.dto.ShoppingCartDTO;
import com.cake.result.Result;
import com.cake.service.ShoppingCartService;
import com.cake.vo.ShoppingCartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@RequiredArgsConstructor
@Api(tags = "购物车相关接口")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PutMapping("/add")
    @ApiOperation("添加到购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        shoppingCartService.add(shoppingCartDTO);
        return Result.success();

    }

    @GetMapping("/list")
    @ApiOperation("获得购物车列表")
    public Result<List<ShoppingCartVO>> list(){
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartService.list();
        return Result.success(shoppingCartVOList);
    }

    @PostMapping("/update")
    @ApiOperation("更新数量")
    public Result update(@RequestBody ShoppingCartDTO shoppingCartDTO){
        shoppingCartService.update(shoppingCartDTO);
        return Result.success();
    }

    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除某个商品")
    public Result delete(@PathVariable Long id){
        shoppingCartService.delete(id);
        return Result.success();
    }

    @DeleteMapping("/batchRemove")
    @ApiOperation("批量删除")
    public Result batchRemove(@RequestBody List<Long> ids){
        shoppingCartService.batchRemove(ids);
        return Result.success();
    }

    @DeleteMapping("/clearCart")
    @ApiOperation("清空购物车")
    public Result clearCart(){
        shoppingCartService.clearCart();
        return Result.success();
    }
}
