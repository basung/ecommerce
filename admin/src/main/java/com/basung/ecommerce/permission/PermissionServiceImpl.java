package com.basung.ecommerce.permission;

import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */

@Transactional
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, String, GlobalException> implements PermissionService {

  @Resource
  PermissionRepository permissionRepository;

  protected GenericRepository<Permission, String> getRepository() {
    return permissionRepository;
  }


  public List getPermissionsByRoleId(String roleId){

    return permissionRepository.getPermissionsByRoleId(roleId);

  }

}
