package com.basung.ecommerce.logistics.carriage;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * Date: 2018-11-02-下午1:17
 */

@Entity
@Table(name = "BSS_LOGISTICS_CARRIAGE_TEMPLATE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class CarriageTemplate extends AutoEntity {

    //首重
    @Column(name = "first_weight")
    private double firstWeight;

    //首费
    @Column(name = "first_price")
    private double firstPrice;

    //续重
    @Column(name = "additional_weight")
    private double additionalWeight;

    //续费
    @Column(name = "additional_price")
    private double additionalPrice;

    //是否是默认地区
    @Column(name = "is_default")
    private double isDefault;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carriage_Template_id", referencedColumnName = "id")
    private List<Region> regions;

}
