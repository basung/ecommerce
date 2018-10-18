package com.basung.ecommerce.article.category;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * Date: 2018-10-18-下午3:42
 */
@Entity
@Table(name = "BSS_ARTICLE_CATEGORY")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Category extends AutoEntity {

    public static final String ROOT_ID = "0";

    /**
     * 文章类别名称
     */
    @Column( name = "name", length = 128 )
    private String name;

    /**
     * 文章类别logo
     */
    @Column( name = "logo" )
    private String logo;

    /**
     * 文章类别父级ID
     */
    @Column(name = "parent_id", nullable = false, length = 64)
    private String parentId=ROOT_ID;

    /**
     * 文章类别描述
     */
    @Column(name = "description", length = 512)
    private String description;

    /**
     * 文章类别排序码，越小越靠前
     */
    @Column(name = "sort_code")
    private int sortCode;

    @Transient
    private List<Category> children;



}
