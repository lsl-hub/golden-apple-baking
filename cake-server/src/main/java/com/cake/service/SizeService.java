package com.cake.service;

import com.cake.entity.Size;

import java.util.List;

public interface SizeService {
    /**
     * 更新尺寸信息
     * @param productId
     * @param specs
     */
    void updateSize(Long productId, List<Size> specs);
}
