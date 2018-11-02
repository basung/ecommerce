package com.basung.ecommerce.permission;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:34
 */
@Entity
@Table(name = "BSS_ADMIN_PERMISSION")
@Data
public class Permission extends AutoEntity {

  /**
   * 权限父编号
   */
  @NotEmpty(message = "bss.action.parent_code.empty.error")
  @Column(name = "parent_id", nullable = false, length = 64)
  private String parentId;


  /**
   * 权限名称
   */
  @NotEmpty(message = "bss.action.name.empty.error")
  @Column(name = "name", nullable = false, length = 128)
  private String name;

  /**
   * 权限地址
   */
  @NotEmpty(message = "bss.action.relation_url.empty.error")
  @Column(name = "relation_url", nullable = false, length = 250)
  private String relationUrl;


  /**
   * 权限请求方法
   */
  @Column(name = "http_method", length = 250)
  private String httpMethod;

  /**
   * 权限描述
   */
  @Column(name = "description", length = 250)
  private String description;


}
