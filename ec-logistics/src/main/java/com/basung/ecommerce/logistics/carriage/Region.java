package com.basung.ecommerce.logistics.carriage;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-11-02-下午1:27
 */


@Entity
@Table(name = "BSS_LOGISTICS_CARRIAGE_TEMPLATE_REGION")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Region extends AutoEntity {

    //区域码
    @Column(name = "region_came")
    private double regionCode;

    //区域名称
    @Column(name = "region_name")
    private String regionName;

}
