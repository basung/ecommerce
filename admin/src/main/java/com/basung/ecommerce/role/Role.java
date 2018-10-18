package com.basung.ecommerce.role;

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
@Table(name = "BSS_ADMIN_ROLE")
@Data
public class Role extends AutoEntity {

    public Role(String name, String description) {

	  this.name = name;
	  this.description = description;

    }

    /**
     * 角色名称
     */
    @NotEmpty(message = "bss.action.name.empty.error")
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    /**
     * 角色描述
     */
    @Column(name = "description", length = 250)
    private String description;


}
