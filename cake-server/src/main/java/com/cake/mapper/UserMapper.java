package com.cake.mapper;

import com.cake.entity.User;
import com.cake.vo.GetUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 查询用户
     * @param user
     * @return
     */
    User select(User user);

    /**
     * 新增用户
     * @param user
     */

    void add(User user);

    /**
     * 获得用户余额
     * @param id
     * @return
     */
    User getAmount(Long id);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 得到用户信息
     * @return
     */
    GetUser getUserInfo(Long id);

}
