package com.cake.service.impl;

import com.cake.context.BaseContext;
import com.cake.dto.AddressDTO;
import com.cake.entity.Address;
import com.cake.mapper.AddressMapper;
import com.cake.service.AddressService;
import com.cake.vo.AddressVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;


    /**
     * 添加地址
     *
     * @param addressDTO
     */
    @Override
    @Transactional
    public AddressVO add(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO,address);
        //设置属性
        address.setUserId(BaseContext.getCurrentId());
        address.setCreateTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        //添加
        addressMapper.add(address);
        //如果这是第一个地址，就设为默认地址
        Long userId = BaseContext.getCurrentId();
        List<AddressVO> addresses = addressMapper.list(userId);
        AddressVO addressV = addresses.get(0);
        if(addresses.size() == 1 && addressV.getIsDefault() == 0){
            //设为默认地址
            address.setIsDefault(1);
            address.setUpdateTime(LocalDateTime.now());
            addressMapper.update(address);
        }
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(address,addressVO);
        return addressVO;
    }

    /**
     * 获得当前用户的地址信息
     *
     * @return
     */
    @Override
    public List<AddressVO> list() {

        //当前用户的id
        Long userId = BaseContext.getCurrentId();
        //查询
        List<AddressVO> addressVOList = addressMapper.list(userId);

        return addressVOList;
    }

    /**
     * 更新地址
     *
     * @param addressDTO
     */
    @Override
    @Transactional
    public void update(AddressDTO addressDTO) {
        //判断是否是为默认地址
        if(addressDTO.getIsDefault() == 1){
            //先取消其他所有地址的默认状态
            addressMapper.cancelOtherDefaultAddresses(addressDTO.getId());
        }
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO,address);
        address.setUpdateTime(LocalDateTime.now());
        addressMapper.update(address);
    }

    /**
     * 删除地址
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        addressMapper.delete(id);

        //用户id
        Long userId = BaseContext.getCurrentId();
        List<AddressVO> addresses = addressMapper.list(userId);
        //判断是否为空
        if(!addresses.isEmpty()){
            AddressVO addressVO = addresses.get(0);
            //如果只剩下一个地址并且不是默认地址就设为默认地址
            if(addresses.size() == 1 && addressVO.getIsDefault() == 0){
                //设为默认地址

                Address address = new Address();
                BeanUtils.copyProperties(addressVO,address);
                address.setIsDefault(1);
                address.setUpdateTime(LocalDateTime.now());
                addressMapper.update(address);
            }
        }
    }
}
