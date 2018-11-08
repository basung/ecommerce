package com.basung.ecommerce.tenant;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-18-下午2:14
 */

@Entity
@Table(name = "BSS_ADMIN_TENANT")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Tenant extends AutoEntity {

    /**
     * 租户店铺Code
     */
    @Column(name = "code", length = 128)
    private String code;

    /**
     * 租户店铺名称
     */
    @Column(name = "name", unique = true, length = 128)
    private String name;

    /**
     * 租户店铺logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * 租户店铺国家
     */
    @Column(name = "country", length = 32)
    private String country;

    /**
     * 租户店铺省份
     */
    @Column(name = "province", length = 32)
    private String province;

    /**
     * 租户店铺城市
     */
    @Column(name = "city", length = 32)
    private String city;

    /**
     * 租户店铺区域,供前端使用
     */
    @Column(name = "region")
    private String region;

    /**
     * 租户店铺地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 租户店铺网址
     */
    @Column(name = "website")
    private String website;

    /**
     * 租户店铺描述
     */
    @Column(name = "description", length = 255)
    private String description;

    /**
     * 租户店铺电话
     */
    @Column(name = "telephone", length = 20)
    private String telephone;

    /**
     * 租户店铺传真
     */
    @Column(name = "fax", length = 20)
    private String fax;

    /**
     * 租户店铺邮编
     */
    @Column(name = "zip_code", length = 20)
    private String zipCode;

    /**
     * 租户店铺联系人
     */
    @Column(name = "contact_name", length = 64)
    protected String contactName;

    /**
     * 租户店铺联系电话
     */
    @Column(name = "contact_mobile", length = 20)
    protected String contactMobile;

    /**
     * 租户店铺联系人职位
     */
    @Column(name = "contact_position")
    protected String contactPosition;

    /**
     * 租户店铺开户银行
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 租户店铺银行账号
     */
    @Column(
		name = "bank_account"
    )
    private String bankAccount;

    /**
     * 租户店铺发票抬头
     */
    @Column(name = "invoice_title")
    private String invoiceTitle;

}
