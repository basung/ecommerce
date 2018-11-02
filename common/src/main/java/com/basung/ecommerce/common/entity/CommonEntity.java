package com.basung.ecommerce.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-09-29-上午10:41
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public  abstract class CommonEntity implements Serializable, CommonConstant {

  private static final long serialVersionUID = 1195969732659409799L;

  @ApiModelProperty(value="版本")
  @Version
  @Column(name = "version")
  private long version = 0;

  @ApiModelProperty(value="是否可用")
  @Column(name = "is_active")
  private Integer isActive = 1;

  @ApiModelProperty(value="是否删除")
  @Column(name = "is_del")
  private Byte isDel = 0;

  @ApiModelProperty(value="创建者")
  @Column(name = "creator", updatable = false)
  private String creator;

  @ApiModelProperty(value="创建时间")
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="create_time", nullable = false, updatable = false)
  private Date createTime = new Date();

  @ApiModelProperty(value="最后修改人")
  @Column(name = "modifier",updatable = true)
  private String modifier;

  @LastModifiedDate
  @ApiModelProperty(value="最后修改时间")
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="modifier_time", nullable = false )
  private Date modifierTime;

  /**
   * 排序码，越小越靠前
   */
  @ApiModelProperty(value="排序码")
  @Column(name = "order_num")
  private int orderNum = 0;


}
