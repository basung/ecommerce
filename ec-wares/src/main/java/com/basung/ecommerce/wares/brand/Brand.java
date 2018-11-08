package com.basung.ecommerce.wares.brand;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Date: 2018-10-19-上午10:04
 */

@Entity
@Table(name = "BSS_WARES_BRAND")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Brand extends AutoEntity {

    /**
     * 商品品牌中文名称
     */
    @Column(name = "brand_name", length = 128)
    private String brandName;

    /**
     * 商品品牌英文名称
     */
    @Column(name = "brand_en_name", length = 128)
    private String brandEnName;

    /**
     * 商品品牌图片
     */
    @Column(name = "brand_logo", length = 256)
    private String brandLogo;

    /**
     * 商品品牌官网地址
     */
    @Column(name = "brand_url", length = 256)
    private String brandUrl;

    /**
     * 品牌故事
     */
    @Lob
    @Column(name = "brand_desc")
    private String brandDesc;


}
