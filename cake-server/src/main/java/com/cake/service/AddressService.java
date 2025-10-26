package com.cake.service;

import com.cake.dto.AddressDTO;
import com.cake.vo.AddressVO;

import java.util.List;

public interface AddressService {
    /**
     * 添加地址
     * @param addressDTO
     */
    AddressVO add(AddressDTO addressDTO);

    /**
     * 获得当前用户的地址信息
     * @return
     */
    List<AddressVO> list();

    /**
     * 更新地址
     * @param addressDTO
     */
    void update(AddressDTO addressDTO);

    /**
     * 删除地址
     * @param id
     */
    void delete(Long id);
}
