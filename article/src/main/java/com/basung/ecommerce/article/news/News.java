package com.basung.ecommerce.article.news;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Date: 2018-10-18-下午3:43
 */

@Entity
@Table(name = "BSS_ARTICLE_NEWS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class News extends AutoEntity {

    /**
     * 文章名称
     */
    @Column( name = "name", length = 128 )
    private String name;

    /**
     * 文章作者
     */
    @Column( name = "author", length = 128 )
    private String author;

    /**
     * 文章来源
     */
    @Column( name = "news_source", length = 128 )
    private String newsSource;

    /**
     * 文章编辑
     */
    @Column( name = "news_editor", length = 128 )
    private String newsEditor;

    /**
     * 文章logo
     */
    @Column( name = "logo" )
    private String logo;

    /**
     * 文章关联类别
     */
    @Column(name = "category_id", nullable = false, length = 64)
    private String categoryId;

    /**
     * 文章关联名称
     */
    @Column(name = "category_name", nullable = false, length = 64)
    private String categoryName;

    /**
     * 文章描述
     */
    @Column(name = "description", length = 512)
    private String description;

    /**
     * 文章详情
     */
    @Lob
    @Column(name = "details")
    private String details;

}
