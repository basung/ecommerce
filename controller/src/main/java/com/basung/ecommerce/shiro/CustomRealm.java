package com.basung.ecommerce.shiro;

import com.basung.ecommerce.adminUser.AdminUser;
import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.redis.RedisUtil;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.permission.Permission;
import com.basung.ecommerce.permission.PermissionService;
import com.basung.ecommerce.utils.JWTUtil;
import com.basung.ecommerce.utils.JsonUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Description 自定义 Realm
 * @Date 2018-04-09
 * @Time 16:58
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    public CustomRealm(AdminUserService adminUserService) {
	  this.adminUserService = adminUserService;
    }

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
	  return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
	  HttpServletResponse httpServletResponse = null;
	  System.out.println("————身份认证方法————");
	  String token = (String) authenticationToken.getCredentials();
	  // 解密获得username，用于和数据库进行对比
	  String userId = JWTUtil.getUserId(token);
	  if (userId == null || !JWTUtil.verify(token, userId)) {
		throw new AuthenticationException("token认证失败！");
	  }
	  AdminUser adminUser = new AdminUser();

	  adminUser = adminUserService.getAdminUserByUserId(userId);

	  logger.info(" adminUser === {}  ", adminUser.toString());

	  if (adminUser.getLoginName() == null) {
		throw new AuthenticationException("该用户不存在！");
	  }
	  if (adminUser.getPassword() == null) {
		throw new AuthenticationException("该用户密码出错！");
	  }
	  if (adminUser.getIsActive() != 1) {
		throw new AuthenticationException("该用户已被封号！");
	  }
	  return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	  System.out.println("————权限认证————");
	  System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

	  //获得该用户Id
	  String adminUserId = JWTUtil.getUserId(principals.toString());
	  SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	  //获取用户
	  AdminUser adminUser = new AdminUser();

	  adminUser = adminUserService.getAdminUserByUserId(adminUserId);

	  logger.info(" adminUser ==222== {}  ", adminUser.toString());

	  //每个角色拥有默认的权限
	  List<Permission> permissionList = new ArrayList();

	  //判断该ID的用户是否存在缓存中
	  if (redisUtil.hasKey("User_Permission_" + adminUserId)) {
		String permissions = redisUtil.get("User_Permission_" + adminUserId);
		permissionList = JsonUtils.jsonToList(permissions, Permission.class);

	  } else {
		//获得该用户角色Id
		String roleId = adminUser.getRoleId();
		try {
		    permissionList = permissionService.getPermissionsByRoleId(roleId);
		} catch (GlobalException e) {
		    e.printStackTrace();
		}
	  }
	  //每个用户可以设置新的权限
	  Set<String> permissionSet = new HashSet<>();
	  Iterator<Permission> iterator = permissionList.iterator();
	  while (iterator.hasNext()) {
		Permission permission = iterator.next();
		permissionSet.add(permission.getRelationUrl());
	  }
	  logger.info("permissionSet === {} ", permissionSet);
	  //设置该用户拥有的角色和权限
	  info.setStringPermissions(permissionSet);
	  return info;
    }
}
