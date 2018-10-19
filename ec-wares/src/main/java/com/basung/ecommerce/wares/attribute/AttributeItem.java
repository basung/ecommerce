package com.basung.ecommerce.wares.attribute;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-19-下午2:24
 */

@Entity
@Table(name = "BSS_WEARS_ATTRIBUTE_ITEM")
@Data
@EntityListeners(AuditingEntityListener.class)
public class AttributeItem extends AutoEntity {

    /**
     * 关联的 属性组 ID
     */
    @Column( name = "attr_id", length = 128 )
    private String attrId;

    /**
     * 属性项名称
     */
    @Column( name = "attr_item_name", length = 128 )
    private String attrItemName;

    /**
     * 属性项的值
     */
    @Column( name = "attr_item_value", length = 128 )
    private String attrItemValue;


}
