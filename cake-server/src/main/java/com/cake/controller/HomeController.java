package com.cake.controller;

import com.cake.result.Result;
import com.cake.service.HomeService;
import com.cake.vo.CategoryRankingVO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@Api(tags = "首页相关接口")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/getCategoryRankings")
    public Result<List<CategoryRankingVO>> getCategoryRankings(){
        List<CategoryRankingVO> products = homeService.getCategoryRankings();
        return Result.success(products);

    }
}
