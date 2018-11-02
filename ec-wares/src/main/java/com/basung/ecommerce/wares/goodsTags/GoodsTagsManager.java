package com.basung.ecommerce.wares.goodsTags;

import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;

/**
 * Date: 2018-10-23-下午2:43
 */
public interface GoodsTagsManager extends GenericService<GoodsTags, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;
}
