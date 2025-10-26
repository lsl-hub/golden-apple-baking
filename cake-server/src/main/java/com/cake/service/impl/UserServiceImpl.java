package com.cake.service.impl;

import com.cake.constant.JwtClaimsConstant;
import com.cake.constant.MessageConstant;
import com.cake.context.BaseContext;
import com.cake.dto.PasswordDTO;
import com.cake.entity.User;
import com.cake.exception.LoginFailedException;
import com.cake.exception.PasswordErrorException;
import com.cake.exception.UserAlreadyExistsException;
import com.cake.mapper.UserMapper;
import com.cake.properties.JwtProperties;
import com.cake.service.UserService;
import com.cake.utils.JwtUtil;
import com.cake.vo.GetUser;
import com.cake.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final BigDecimal amount = new BigDecimal(10000000);
    private final UserMapper userMapper;

    private final JwtProperties jwtProperties;
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public UserVO login(User user) {
        //加密密文
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User us = userMapper.select(user);
        if (us == null){
            throw new LoginFailedException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        UserVO userVO = new UserVO();
        userVO.setName(us.getName());
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, us.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        userVO.setToken(token);
        return userVO;
    }

    /**
     * 用户注册
     *
     * @param user
     *
     */
    @Override
    public void register(User user) {

        User user1 = userMapper.select(user);
        if(user1 != null){
            throw new UserAlreadyExistsException(MessageConstant.USER_ALREADY_EXISTS);
        }else{
            user.setAmount(amount);
            //对密码进行密文加密
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userMapper.add(user);
        }




    }

    /**
     * 得到用户信息
     *
     * @return
     */
    @Override
    public GetUser getUserInfo() {
        //获得当前用户的id
        Long userId = BaseContext.getCurrentId();
        return userMapper.getUserInfo(userId);
    }

    /**
     * 更新用户名字
     *
     * @param name
     */
    @Override
    public void updateName(String name) {
        //用户的id
        Long userId = BaseContext.getCurrentId();
        User user = new User();
        user.setName(name);
        user.setId(userId);
        userMapper.update(user);
    }

    /**
     * 更改密码
     *
     * @param passwordDTO
     */
    @Override
    public void updatePassword(PasswordDTO passwordDTO) {
        //用户id
        Long userId = BaseContext.getCurrentId();
        User user = new User();
        user.setId(userId);
        //查询用户
        User userInfo = userMapper.select(user);
        //原密码
        String oldPassword = passwordDTO.getOldPassword();
        //新密码
        String newPassword = passwordDTO.getNewPassword();

        //对原密码进行加密并比对
        String oldPasswordMd5 = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        if(!oldPasswordMd5.equals(userInfo.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //对新密码加密
        String newPasswordMd5 = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        user.setPassword(newPasswordMd5);

        //更新
        userMapper.update(user);


    }
}
