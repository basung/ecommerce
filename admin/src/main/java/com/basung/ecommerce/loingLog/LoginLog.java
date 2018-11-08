package com.basung.ecommerce.loingLog;

import com.basung.ecommerce.common.entity.AutoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Date: 2018-10-09-下午5:13
 */

@Entity
@Table(name = "BSS_ADMIN_LOGIN_LOG")
@Data
@EntityListeners(AuditingEntityListener.class)
public class LoginLog extends AutoEntity {

    /**
     * 日志名称
     */
    @Column(name = "log_name", length = 128)
    private String logName;

    /**
     * 登录人员ID
     */
    @Column(name = "user_id", length = 128)
    private String userId;

    /**
     * 管理员id
     */
    @Column(name = "login_name", length = 128)
    private String loginName;

    /**
     * 是否执行成功
     */
    private Integer succeed;

    /**
     * 具体消息
     */
    @Column(length = 256)
    private String message;

    /**
     * 登录ip
     */
    private String ip;
}
