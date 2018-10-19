package com.basung.ecommerce.wares.tags;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 *
 * 商品Tag eg: 热卖、新品、特价...
 *
 * Date: 2018-10-19-上午9:53
 */

@Entity
@Table(name = "BSS_WEARS_TAGS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Tags extends AutoEntity {

    /**
     * tag名称
     */
    @Column( name = "name", length = 128 )
    private String name;

    /**
     * tag颜色
     */
    @Column( name = "color", length = 128 )
    private String color;

    /**
     * tag描述
     */
    @Column( name = "description", length = 128 )
    private String description;

}
