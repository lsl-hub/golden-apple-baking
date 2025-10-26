package com.cake.controller;

import com.cake.dto.PasswordDTO;
import com.cake.entity.User;
import com.cake.result.Result;
import com.cake.service.UserService;
import com.cake.vo.GetUser;
import com.cake.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags = "用户登录相关接口")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserVO> login(@RequestBody User user){
        UserVO userVO = userService.login(user);
        return Result.success(userVO);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")

    public Result register(@RequestBody User user){
        userService.register(user);
        return Result.success();
    }

    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public Result logout(){
        return Result.success();
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("得到用户信息")
    public Result<GetUser> getUserInfo(){
        return  Result.success(userService.getUserInfo());
    }

    @PostMapping("/updateName/{name}")
    @ApiOperation("更新用户名字")
    public Result updateName(@PathVariable String name){
        userService.updateName(name);
        return Result.success();
    }

    @PostMapping("/updatePassword")
    @ApiOperation("更改密码")
    public Result updatePassword(@RequestBody PasswordDTO password){
        userService.updatePassword(password);
        return Result.success();
    }
}
