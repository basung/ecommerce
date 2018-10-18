package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.loingLog.LoginLog;
import com.basung.ecommerce.loingLog.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2018-10-09-下午5:36
 */

@Api(value = "平台用户登录日志接口", tags = {"平台用户登录日志接口"})
@RestController
@RequestMapping("/admin/loginLog")
public class LoginLogController extends AutoEntityController<LoginLog, String, GlobalException, LoginLogService> {

    @Autowired
    LoginLogService loginLogService;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = loginLogService;
    }

    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = LoginLog.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  queryAutoEntity(request, response);
    }

}
