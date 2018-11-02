package com.basung.ecommerce.wares.attribute;

import com.basung.ecommerce.common.repository.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午2:27
 */
public interface AttributeDao extends GenericRepository<Attribute, String> {

    @Modifying
    @Transactional
    @Query(value = " DELETE FROM bss_wares_goods_attribute WHERE goods_id = ?1 ", nativeQuery = true)
    void removeByGoodsId(String goodsId);

}
