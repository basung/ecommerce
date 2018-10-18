package com.basung.ecommerce.operationLog;

import com.basung.ecommerce.common.entity.AutoEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

/**
 * Date: 2018-10-09-下午6:03
 */

@Entity
@Table(name = "BSS_ADMIN_OPERATION_LOG")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OperationLog extends AutoEntity {


    /**
     * 用户id
     */
    @Column(name = "user_id",  length = 128)
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_Name",  length = 128)
    private String userName;

    /**
     * 请求URL
     */
    @Column(name = "url",  length = 256)
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 类方法
     */
    @Column(name = "class_method",  length = 256)
    private String classMethod;


}
