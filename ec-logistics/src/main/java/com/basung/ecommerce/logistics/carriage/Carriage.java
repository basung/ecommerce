package com.basung.ecommerce.logistics.carriage;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * Date: 2018-11-02-下午1:10
 */

@Entity
@Table(name = "BSS_LOGISTICS_CARRIAGE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Carriage extends AutoEntity {

    /**
     * 运费模版名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 计费类型
     */
    @Column(name = "charging_type", nullable = false)
    private String chargingType;

    /**
     * 物流公司Id
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 物流公司名称
     */
    @Column(name = "company_name")
    private String companyName;


    /**
     * 描述
     */
    @Lob
    @Column(name = "carriage_desc")
    private String carriageDesc;

    /**
     * 运费详情
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carriage_id", referencedColumnName = "id")
    private List<CarriageTemplate> carriageTemplates;

}
