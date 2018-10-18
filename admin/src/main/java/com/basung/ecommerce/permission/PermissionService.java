package com.basung.ecommerce.permission;

import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */
public interface PermissionService extends GenericService<Permission, String, GlobalException> {

    List getPermissionsByRoleId(String roleId) throws GlobalException;

}
