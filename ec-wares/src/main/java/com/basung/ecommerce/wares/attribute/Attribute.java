package com.basung.ecommerce.wares.attribute;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-19-下午2:16
 */

@Entity
@Table(name = "BSS_WARES_GOODS_ATTRIBUTE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Attribute extends AutoEntity {

    /**
     * 属性组
     */
    @Column(name = "attr_name")
    private String attrName;

    /**
     * 属性值
     */
    @Column(name = "attr_value")
    private String attrValue;


}
