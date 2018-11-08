package com.basung.ecommerce.utils;

import com.basung.ecommerce.adminUser.AdminUser;
import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.entity.AutoEntity;
import com.basung.ecommerce.common.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2018-10-18-下午12:26
 */

@Component
public class ControllerUtils<T extends AutoEntity> {

    private final static Logger logger = LoggerFactory.getLogger(ControllerUtils.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AdminUserService adminUserService;


    public T setTenantInfoByCreate(T autoEntity) {

	  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	  HttpServletRequest request = attributes.getRequest();

	  AdminUser adminUser;
	  String token = request.getHeader("Authorization");
	  logger.info(" authorization === {} ", token);
	  if (token != null) {
		String adminUserId = JWTUtil.getUserId(token);
		//判断该ID的用户是否存在缓存中
		if (redisUtil.hasKey("User_Info_" + adminUserId)) {
		    String user = redisUtil.get("User_Info_" + adminUserId);
		    adminUser = JsonUtils.jsonToPojo(user, AdminUser.class);
		} else {
		    adminUser = adminUserService.getAdminUserByUserId(adminUserId);
		}
		autoEntity.setTenantId(adminUser.getId());
		autoEntity.setCreator(adminUser.getLoginName());
		autoEntity.setModifier(adminUser.getLoginName());
	  }
	  return autoEntity;

    }

    public T setTenantInfoByUpdate(T autoEntity) {

	  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	  HttpServletRequest request = attributes.getRequest();

	  AdminUser adminUser;
	  String token = request.getHeader("Authorization");
	  logger.info(" authorization === {} ", token);
	  String adminUserId = JWTUtil.getUserId(token);
	  //判断该ID的用户是否存在缓存中
	  if (redisUtil.hasKey("User_Info_" + adminUserId)) {
		String user = redisUtil.get("User_Info_" + adminUserId);
		adminUser = JsonUtils.jsonToPojo(user, AdminUser.class);
	  } else {
		adminUser = adminUserService.getAdminUserByUserId(adminUserId);
	  }
	  autoEntity.setModifier(adminUser.getLoginName());

	  return autoEntity;

    }
}
