package com.basung.ecommerce.logistics.company;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-11-02-下午12:37
 */

@Entity
@Table(name = "BSS_LOGISTICS_COMPANY")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Company extends AutoEntity {

    /**
     * 物流公司名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 物流公司代码
     */
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * 物流公司网址
     */
    @Column(name = "website")
    private String website;

    /**
     * 物流公司查询网址
     */
    @Column(name = "request_url")
    private String requestUrl;

}
