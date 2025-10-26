package com.cake.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.cake.entity.Region;
import com.cake.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
@Api(tags = "地区相关接口")
public class RegionController {
    @GetMapping("/list")
    @ApiOperation("获得地区信息")
    public Result<List<Region>> list() throws IOException {

        //读取resources/data/region.json文件
        ClassPathResource resource = new ClassPathResource("/data/region.json");
        InputStream inputStream = resource.getInputStream();

        //使用Gson来解析JSON
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        List<Region> regions = gson.fromJson(reader,new TypeToken<List<Region>>(){}.getType());

        //返回数据
        return Result.success(regions);
    }
}
