package com.basung.ecommerce.wares.category;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-19-上午10:15
 */


@Entity
@Table(name = "BSS_WEARS_CATEGORY")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Category extends AutoEntity {

    public static final String ROOT_ID = "0";

    /**
     * 商品分类名称
     */
    @Column( name = "category_name", length = 128 )
    private String categoryName;

    /**
     * 商品分类图片
     */
    @Column( name = "category_logo", length = 256 )
    private String categoryLogo;

    /**
     * 商品分类父级ID
     */
    @Column( name = "parent_id", length = 256 )
    private String parentId = ROOT_ID;

    /**
     * 商品分类描述
     */
    @Column(name = "category_desc", length = 512)
    private String categoryDesc;

    /**
     * 该分类下商品数量
     */
    @Column(name = "goods_count")
    private int goodsCount;


}
