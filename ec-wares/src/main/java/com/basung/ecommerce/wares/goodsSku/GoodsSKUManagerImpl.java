package com.basung.ecommerce.wares.goodsSku;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.wares.goods.GoodsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:41
 */

@Transactional
@Service
public class GoodsSKUManagerImpl extends GenericServiceImpl<GoodsSKU, String, GlobalException> implements GoodsSKUManager {

    @Resource
    GoodsSKUDao goodsSKUDao;

    protected GenericRepository<GoodsSKU, String> getRepository(){ return goodsSKUDao; }

}
