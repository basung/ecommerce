package com.basung.ecommerce.wares.goodsImage;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:32
 */
@Transactional
@Service
public class GoodsImageManagerImpl extends GenericServiceImpl<GoodsImage, String, GlobalException> implements GoodsImageManager {

    @Resource
    GoodsImageDao goodsImageDao;

    protected GenericRepository<GoodsImage, String> getRepository(){ return goodsImageDao; }


    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
        goodsImageDao.removeByGoodsId(goodsId);
    }

}
