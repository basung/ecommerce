package com.basung.ecommerce.AOP;

import com.basung.ecommerce.adminUser.AdminUser;
import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.operationLog.OperationLog;
import com.basung.ecommerce.operationLog.OperationLogService;
import com.basung.ecommerce.support.StrKit;
import com.basung.ecommerce.utils.JWTUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2018-10-09-下午6:19
 */

@Aspect
@Component
public class OperationLogAOP {

    private final static Logger logger = LoggerFactory.getLogger(OperationLogAOP.class);

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private AdminUserService adminUserService;

    @Pointcut("execution(public * com.basung.ecommerce.controller..*.*(..))")
    public void operationLog() {
    }


    @Before("operationLog()")
    public void doBefore(JoinPoint joinPoint) {
	  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	  HttpServletRequest request = attributes.getRequest();

	  //Token
	  String token = request.getHeader("Authorization");
	  String userName = null;
	  String userId = null;
	  if(!StrKit.isBlank(token)){
		logger.info("token====AOP===={}", request.getHeader("Authorization"));
		userId = JWTUtil.getUserId(token);
		if(userId != null){
		    AdminUser adminUser = adminUserService.getAdminUserByUserId(userId);
		    userName = adminUser.getLoginName();
		}

	  }

	  //url
	  logger.info("url={}", request.getRequestURL());

	  //method
	  logger.info("method={}", request.getMethod());

	  //ip
	  logger.info("ip={}", request.getRemoteAddr());

	  //类方法
	  logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

	  //参数
	  logger.info("args={}", joinPoint.getArgs().toString());

	  OperationLog operationLog = new OperationLog();
	  operationLog.setUserId(userId);
	  operationLog.setUserName(userName);
	  operationLog.setUrl(request.getRequestURL().toString());
	  operationLog.setMethod(request.getMethod());
	  operationLog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	  logger.info("operationLog={}", operationLog);
	  operationLogService.save(operationLog);
    }
}
