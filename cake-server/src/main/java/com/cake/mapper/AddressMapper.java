package com.cake.mapper;

import com.cake.entity.Address;
import com.cake.vo.AddressVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    /**
     * 添加地址
     * @param address
     */
    void add(Address address);

    /**
     * 获得当前用户的地址信息
     * @return
     */
    List<AddressVO> list(Long UserId);

    /**
     * 更新地址
     * @param address
     */
    void update(Address address);

    /**
     * 取消其他所有地址的默认状态
     * @param id
     */
    void cancelOtherDefaultAddresses(Long id);

    /**
     * 删除地址
     * @param id
     */
    void delete(Long id);
}
