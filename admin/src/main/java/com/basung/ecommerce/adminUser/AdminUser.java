package com.basung.ecommerce.adminUser;

import com.basung.ecommerce.common.entity.AutoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-09-29-下午12:51
 */
@Entity
@Table(name = "BSS_ADMIN_USER")
@Data
@EntityListeners(AuditingEntityListener.class)
public class AdminUser extends AutoEntity {

    public static final String ASSOCIATED_TYPE_SUPERADMIN = "superAdmin";
    public static final String ASSOCIATED_TYPE_TENANT = "tenant";
    public static final String ASSOCIATED_TYPE_EMPLOYEE = "employee";
    public static final String ASSOCIATED_TYPE_MERCHANT = "merchant";
    public static final String ASSOCIATED_TYPE_SUPPLIER = "supplier";

    @ApiModelProperty(value = "登录账号")
    @NotBlank(message = "用户名不能为空")
    @Column(name = "login_name", nullable = false, updatable = false, length = 128)
    private String loginName;

    @NotBlank(message = "用户密码不能为空")
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "salt", length = 32)
    private String salt;

    @Column(name = "true_name", length = 128)
    private String trueName;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "telephone", length = 32)
    private String telephone;

    @Column(name = "mobile", length = 32)
    private String mobile;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 头像
     */
    @Column(name = "avatar", length = 256)
    private String avatar;

    /**
     * 角色id
     */
    @Column(name = "role_Id", nullable = false)
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_Name", nullable = false)
    private String roleName;

    @Column(name = "associated_type", nullable = false, length = 32)
    private String associatedType;


}
