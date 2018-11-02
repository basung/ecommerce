package com.basung.ecommerce.wares.goodsImage;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-19-下午12:25
 */

@Entity
@Table(name = "BSS_WARES_GOODS_IMAGE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GoodsImage extends AutoEntity {

    /**
     * 图片路径
     */
    @Column(name = "image_path")
    private String imagePath;

}
