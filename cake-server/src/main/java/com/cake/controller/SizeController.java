package com.cake.controller;

import com.cake.entity.Size;
import com.cake.result.Result;
import com.cake.service.SizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Slf4j
@Api(tags = "尺寸相关接口")
public class SizeController {

    private final SizeService sizeService;

    @PostMapping("/update/{productId}")
    @ApiOperation("更新尺寸信息")
    public Result updateSize(@PathVariable Long productId,@RequestBody List<Size> specs){
        sizeService.updateSize(productId,specs);
        return Result.success();
    }
}
