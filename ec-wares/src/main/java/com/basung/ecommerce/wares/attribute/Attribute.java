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
@Table(name = "BSS_WEARS_ATTRIBUTE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Attribute extends AutoEntity {

    //属性关联分类标识
    public static final int ATTR_TYPE_CATEGORY = 0;
    //属性关联商品标识
    public static final int ATTR_TYPE_GOODS = 1;

    /**
     * 属性组关联类型
     */
    @Column( name = "attr_type" )
    private int attrType = ATTR_TYPE_CATEGORY;

    /**
     * 属性组关联 类型的 ID
     */
    @Column( name = "related_id", length = 128 )
    private String relatedId;

    /**
     * 属性组名称
     */
    @Column( name = "attr_name", length = 128 )
    private String attrName;

}
