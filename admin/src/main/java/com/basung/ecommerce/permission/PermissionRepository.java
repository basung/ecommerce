package com.basung.ecommerce.permission;

import com.basung.ecommerce.common.repository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
public interface PermissionRepository extends GenericRepository<Permission, String> {

    @Query(value = "select p.* from bss_admin_permission p left join bss_admin_role_permission rp on p.id=rp.relation_id where rp.role_id = ?1", nativeQuery = true)
    List<Permission> getPermissionsByRoleId(String roleId);

}
