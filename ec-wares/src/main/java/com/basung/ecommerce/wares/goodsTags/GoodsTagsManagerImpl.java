package com.basung.ecommerce.wares.goodsTags;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-23-下午2:43
 */

@Transactional
@Service
public class GoodsTagsManagerImpl extends GenericServiceImpl<GoodsTags, String, GlobalException> implements GoodsTagsManager {

    @Resource
    GoodsTagsDao goodsTagsDao;

    protected GenericRepository<GoodsTags, String> getRepository() {
	  return goodsTagsDao;
    }

    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
	  goodsTagsDao.removeByGoodsId(goodsId);
    }

}
