package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.adminUser.AdminUser;
import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.controller.ResponseUtils;
import com.basung.ecommerce.common.redis.RedisOperator;
import com.basung.ecommerce.common.redis.RedisUtil;
import com.basung.ecommerce.exception.ExceptionEnum;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.loingLog.LoginLog;
import com.basung.ecommerce.loingLog.LoginLogService;
import com.basung.ecommerce.permission.Permission;
import com.basung.ecommerce.permission.PermissionService;
import com.basung.ecommerce.utils.JWTUtil;
import com.basung.ecommerce.utils.JsonUtils;
import com.basung.ecommerce.utils.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.basung.ecommerce.support.HttpKit.getIp;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-10-07-下午3:21
 */

@Api(value = "平台用户登录接口", tags = {"平台用户登录接口"})
@RestController
@RequestMapping("/admin/account")
public class AdminLoginController extends AutoEntityController<AdminUser, String, GlobalException, AdminUserService> {

    private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

    // Redis过期时间 24 小时
    private static final long EXPIRE_TIME = 24 * 60 * 60;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private RedisUtil redisUtil;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = adminUserService;
    }

    /**
     * 用户登录接口 通过用户名和密码进行登录
     */
    @ApiOperation(value = "用户登录接口 通过用户名和密码进行登录", notes = "用户登录接口 通过用户名和密码进行登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws Exception {

	  if (!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
		AdminUser adminUser = adminUserService.getAdminUserByUserName(username);


		if (adminUser == null) {
		    //记录登录日志
		    LoginLog loginLog = new LoginLog();
		    loginLog.setLogName("登录失败日志");
		    loginLog.setUserId(null);
		    loginLog.setLoginName(username);
		    loginLog.setSucceed(0);
		    loginLog.setMessage("登录账号 : " + username + ", 该账号不存在！！！");
		    loginLog.setIp(getIp());
		    loginLogService.save(loginLog);
		    ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_NOT_EXIST.getCode(), ExceptionEnum.USER_NOT_EXIST.getMessage());
		} else if (!adminUser.getPassword().equals(MD5.md5(password, adminUser.getSalt()))) {
		    //记录登录日志
		    LoginLog loginLog = new LoginLog();
		    loginLog.setLogName("登录失败日志");
		    loginLog.setUserId(null);
		    loginLog.setLoginName(username);
		    loginLog.setSucceed(0);
		    loginLog.setMessage("登录账号 : " + username + ", 登录密码错误！！！");
		    loginLog.setIp(getIp());
		    loginLogService.save(loginLog);
		    ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_LOGIN_ERROR.getCode(), ExceptionEnum.USER_LOGIN_ERROR.getMessage());
		} else {
		    //记录登录日志
		    LoginLog loginLog = new LoginLog();
		    loginLog.setLogName("登录成功日志");
		    loginLog.setUserId(adminUser.getId());
		    loginLog.setLoginName(username);
		    loginLog.setSucceed(1);
		    loginLog.setMessage("登录账号 : " + username + ", 登录成功！！！");
		    loginLog.setIp(getIp());
		    loginLogService.save(loginLog);

		    //获取该用户所拥有的权限
		    //1、获得该用户角色Id
		    String roleId = adminUser.getRoleId();
		    //2、每个角色拥有默认的权限
		    List<Permission> permissionList = permissionService.getPermissionsByRoleId(roleId);

		    //将用户信息和用户权限存入redis
		    redisUtil.set("User_Info_" + adminUser.getId(), JsonUtils.objectToJson(adminUser), EXPIRE_TIME);
		    redisUtil.set("User_Permission_" + adminUser.getId(), JsonUtils.objectToJson(permissionList), EXPIRE_TIME);
		    logger.info(" User_Info_ === {} ", redisUtil.get("User_Info_" + adminUser.getId()));
		    logger.info(" User_Permission_ === {} ", redisUtil.get("User_Permission_" + adminUser.getId()));

		    //redis 测试
//		    redisOperator.set("adminUser_token", JWTUtil.createToken(username), 20);
//		    String result = redisOperator.get("adminUser_token");
//		    long time = redisOperator.ttl("adminUser_token");
//		    logger.info("result ==== {}",result);
//		    logger.info("time ==== {}",time);
//
//		    redisUtil.set("adminUser_token222", JWTUtil.createToken(username), 20);
//		    String result222 = redisUtil.get("adminUser_token222");
//		    long time222 = redisUtil.getExpire("adminUser_token222");
//		    logger.info("result222 ==== {}",result222);
//		    logger.info("time222 ==== {}",time222);


		    Map responseMap = new HashMap();
		    //根据用户ID生产token值
		    responseMap.put("token", JWTUtil.createToken(adminUser.getId()));
		    responseMap.put("account", adminUser);
		    responseMap.put("permission", permissionList);

		    ResponseUtils.writeSuccessResult(response, responseMap);
		}
	  } else {
		ResponseUtils.writeErrorResult(response, ExceptionEnum.PARAM_NOT_COMPLETE.getCode(), ExceptionEnum.PARAM_NOT_COMPLETE.getMessage());
	  }

    }

}


