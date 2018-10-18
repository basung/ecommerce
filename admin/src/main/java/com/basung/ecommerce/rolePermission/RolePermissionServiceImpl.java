package com.basung.ecommerce.rolePermission;

import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.permission.Permission;
import com.basung.ecommerce.permission.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */

@Transactional
@Service
public class RolePermissionServiceImpl extends GenericServiceImpl<RolePermission, String, GlobalException> implements RolePermissionService {

    private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

    @Resource
    RolePermissionRepository rolePermissionRepository;

    @Resource
    PermissionService permissionService;

    protected GenericRepository<RolePermission, String> getRepository() {
	  return rolePermissionRepository;
    }

    public void createRolePermission(String roleId, String permissionIds) throws GlobalException {

        logger.info("permissionIds === {}", permissionIds );

        //1、删除所有该角色原有的权限
	  this.rolePermissionRepository.removeByRoleId(roleId);

	  //2、数据初始化
	  List<RolePermission> rolePermissionList = new ArrayList();

	  String[] permissionIdsArr = permissionIds.split(",");
	  logger.info("permissionIds === {}", Arrays.toString(permissionIdsArr) );

	  if(permissionIdsArr.length > 1){
		logger.info("permissionIdsArr.length === {}",permissionIdsArr.length );
		for(int index = 0; index < permissionIdsArr.length; index ++) {
		    String permissionId = permissionIdsArr[index];
		    RolePermission rolePermission = new RolePermission();
		    rolePermission.setRoleId(roleId);
		    rolePermission.setRelationId(permissionId);
		    rolePermission.setCreator("rocky");
		    rolePermission.setModifier("rocky");
		    rolePermission.setTenantId("rocky");
		    rolePermissionList.add(rolePermission);
		}

		//3、插入数据库
		rolePermissionRepository.saveAll(rolePermissionList);
	  }
    }


    public List getRolePermission(String roleId) throws GlobalException {

	  List<RolePermission> rolePermissionList = this.rolePermissionRepository.getByRoleId(roleId);

	  List<Map> resultList = new ArrayList();

	  Iterator<RolePermission> iterator = rolePermissionList.iterator();

	  while(iterator.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。

		String permissionId = iterator.next().getRelationId();
		Permission permission = permissionService.findById(permissionId);
		Map permissionMap = new HashMap();
		permissionMap.put("roleId", roleId);
		permissionMap.put("parentCode", permission.getParentCode());
		permissionMap.put("permissionId", permission.getId());
		permissionMap.put("name", permission.getName());
		permissionMap.put("relationUrl", permission.getRelationUrl());
		permissionMap.put("httpMethod", permission.getRelationUrl());
		permissionMap.put("description", permission.getDescription());
		resultList.add(permissionMap);
	  }

        return  rolePermissionList;

    }
}
