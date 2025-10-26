package com.cake.service;

import com.cake.dto.PasswordDTO;
import com.cake.entity.User;
import com.cake.vo.GetUser;
import com.cake.vo.UserVO;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    UserVO login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
   void register(User user);

    /**
     * 得到用户信息
     * @return
     */
    GetUser getUserInfo();

    /**
     * 更新用户名字
     * @param name
     */
    void updateName(String name);

    /**
     * 更改密码
     * @param password
     */
    void updatePassword(PasswordDTO password);
}
