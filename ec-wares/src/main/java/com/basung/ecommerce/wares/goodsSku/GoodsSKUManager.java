package com.basung.ecommerce.wares.goodsSku;

import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;

/**
 * Date: 2018-10-19-下午12:41
 */
public interface GoodsSKUManager extends GenericService<GoodsSKU, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;
}
