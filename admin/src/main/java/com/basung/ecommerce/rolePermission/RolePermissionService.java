package com.basung.ecommerce.rolePermission;

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
public interface RolePermissionService extends GenericService<RolePermission, String, GlobalException> {

    void createRolePermission(String var1, String var2) throws GlobalException;

    List getRolePermission(String roleId) throws GlobalException;
}
