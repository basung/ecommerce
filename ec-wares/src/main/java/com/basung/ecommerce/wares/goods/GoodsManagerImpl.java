package com.basung.ecommerce.wares.goods;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:22
 */

@Transactional
@Service
public class GoodsManagerImpl extends GenericServiceImpl<Goods, String, GlobalException> implements GoodsManager {

    @Resource
    GoodsDao goodsDao;

    protected GenericRepository<Goods, String> getRepository(){ return goodsDao; }

}
