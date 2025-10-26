package com.cake.service.impl;

import com.cake.context.BaseContext;
import com.cake.entity.Size;
import com.cake.mapper.SizeMapper;
import com.cake.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {
    private final SizeMapper sizeMapper;
    /**
     * 更新尺寸信息
     *
     * @param productId
     * @param specs
     */
    @Override
    @Transactional
    public void updateSize(Long productId, List<Size> specs) {
        //更新尺寸表要先删除尺寸
        sizeMapper.deleteSize(productId);

        //设置一些属性
        for (Size spec : specs) {
            spec.setProductId(productId);
            spec.setCreateTime(LocalDateTime.now());
            spec.setUpdateTime(LocalDateTime.now());
            spec.setCreateUser(BaseContext.getCurrentId());
            spec.setUpdateUser(BaseContext.getCurrentId());
        }
        //批量插入表
        sizeMapper.batchInsertSpecs(specs);

    }
}
