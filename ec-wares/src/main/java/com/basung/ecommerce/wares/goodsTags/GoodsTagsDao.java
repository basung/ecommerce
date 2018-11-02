package com.basung.ecommerce.wares.goodsTags;

import com.basung.ecommerce.common.repository.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Date: 2018-10-23-下午2:42
 */
public interface GoodsTagsDao extends GenericRepository<GoodsTags, String> {

    @Modifying
    @Transactional
    @Query(value = " DELETE FROM bss_wares_goods_tags WHERE goods_id = ?1 ", nativeQuery = true)
    void removeByGoodsId(String goodsId);

}
