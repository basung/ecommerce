package com.basung.ecommerce.rolePermission;

import com.basung.ecommerce.common.repository.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:38
 */
@Repository
public interface RolePermissionRepository extends GenericRepository<RolePermission, String> {

    @Modifying
    @Query(value = " DELETE FROM bss_admin_role_permission WHERE role_id = ?1 ", nativeQuery = true)
    void removeByRoleId(String roleId);

    @Query(value = " SELECT * FROM bss_admin_role_permission WHERE role_id = ?1 ", nativeQuery = true)
    List<RolePermission> getByRoleId(String roleId);

}
