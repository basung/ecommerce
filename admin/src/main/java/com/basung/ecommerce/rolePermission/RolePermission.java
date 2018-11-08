package com.basung.ecommerce.rolePermission;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:34
 */
@Entity
@Table(name = "BSS_ADMIN_ROLE_PERMISSION")
@Data
public class RolePermission extends AutoEntity {

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "relation_id", nullable = false)
    private String relationId;


}
