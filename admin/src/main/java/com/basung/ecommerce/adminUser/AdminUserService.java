package com.basung.ecommerce.adminUser;

import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */
public interface AdminUserService extends GenericService<AdminUser, String, GlobalException> {

    AdminUser getAdminUserByUserName(String userName) ;

    AdminUser getAdminUserByUserId(String userId);

}
