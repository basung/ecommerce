package com.basung.ecommerce.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-09-29-上午10:51
 */
@Data
@MappedSuperclass
public class AutoEntity extends CommonEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "Id")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ApiModelProperty(value = "租户Id")
    @Column(name = "tenant_id", updatable = false)
    private String tenantId;

}
