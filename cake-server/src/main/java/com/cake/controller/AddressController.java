package com.cake.controller;

import com.cake.dto.AddressDTO;
import com.cake.result.Result;
import com.cake.service.AddressService;
import com.cake.vo.AddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Api(tags = "地址相关接口")
public class AddressController {
    private final AddressService addressService;

    @PutMapping("/add")
    @ApiOperation("添加地址")
    public Result<AddressVO> add(@RequestBody AddressDTO addressDTO){
        AddressVO addressVO = addressService.add(addressDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("获得当前用户的地址信息")
    public Result<List<AddressVO>> list(){
        List<AddressVO> addressVOList = addressService.list();
        return Result.success(addressVOList);
    }

    @PostMapping("/update")
    @ApiOperation("更新地址")
    public Result update(@RequestBody AddressDTO addressDTO){
        addressService.update(addressDTO);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除地址")
    public Result delete(@PathVariable Long id){
        addressService.delete(id);
        return Result.success();
    }

}
