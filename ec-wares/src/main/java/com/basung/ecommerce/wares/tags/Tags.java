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
@Table(name = "BSS_WARES_TAGS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Tags extends AutoEntity {

    /**
     * tag名称
     */
    @Column( name = "tags_name", length = 128 )
    private String tagsName;

    /**
     * tag颜色
     */
    @Column( name = "tags_color", length = 256 )
    private String tagsColor;

    /**
     * tag颜色
     */
    @Column( name = "tags_color_Hex", length = 256 )
    private String tagsColorHex;

    /**
     * tag图片
     */
    @Column( name = "tags_logo", length = 512 )
    private String tagsLogo;

    /**
     * tag描述
     */
    @Column( name = "tags_desc", length = 512 )
    private String tagsDesc;

}
