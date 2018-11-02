package com.basung.ecommerce.wares.goodsSku;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Date: 2018-10-19-下午12:35
 */


@Entity
@Table(name = "BSS_WARES_GOODS_SKU")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GoodsSKU extends AutoEntity {

    /**
     * 价格,单位为元
     */
    @Column(name = "sale_price", nullable = false)
    private double salePrice;

    /**
     * 市场价格,单位为元
     */
    @Column(name = "market_price")
    private double marketPrice;

    /**
     * 成本价格,单位为元
     */
    @Column(name = "cost_price")
    private double costPrice;

    /**
     * SKU图片
     */
    @Column( name = "sku_image", length = 256 )
    private String skuImage;

    /**
     * SKU 名称 eg: 玉兰油沐浴露200ml
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 库存
     */
    @Column(name = "stock_num", nullable = false)
    private long stockNum;

    /**
     * SKU product code
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 商品条码
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * 商品规格
     */
    @Lob
    @Column(name = "sku_spec")
    private String skuSpec;


}
