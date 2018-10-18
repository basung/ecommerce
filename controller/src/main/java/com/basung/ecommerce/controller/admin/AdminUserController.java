package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.adminUser.AdminUser;
import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.controller.ResponseUtils;
import com.basung.ecommerce.exception.ExceptionEnum;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.utils.ControllerUtils;
import com.basung.ecommerce.utils.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:47
 */

@Api(value = "平台用户管理接口  平台用户管理", tags = {"平台用户管理接口  平台用户管理"})
@RestController
@RequestMapping("/admin/adminUser")
public class AdminUserController extends AutoEntityController<AdminUser, String, GlobalException, AdminUserService> {

    private final static Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = adminUserService;
    }

    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = AdminUser.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  queryAutoEntity(request, response);
    }

    @ApiOperation(value = "新增  ", notes = "保存  新增/修改的  ")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add( @ApiParam(value = "对象", required = true) @RequestBody @Valid AdminUser adminUser, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  if (bindingResult.hasErrors()) {
		logger.info(" bindingResult.getFieldError().getDefaultMessage() === {} ",bindingResult.getFieldError().getDefaultMessage());
		ResponseUtils.writeErrorResult(response, 400,bindingResult.getFieldError().getDefaultMessage());
	  }

	  // 判断账号是否重复
	  AdminUser user = adminUserService.getAdminUserByUserName(adminUser.getLoginName());

	  if (user != null) {
		ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_HAS_EXISTED.getCode(),  ExceptionEnum.USER_HAS_EXISTED.getMessage());
	  } else {

		// 完善账号信息
		adminUser.setSalt(MD5.getRandomSalt(5));
		adminUser.setPassword(MD5.md5(adminUser.getPassword(), adminUser.getSalt()));
		adminUser.setIsActive(1);

		controllerUtils.setTenantInfoByCreate(adminUser);

		//持久化
		addAutoEntity(adminUser, request, response);
	  }
    }


    @ResponseBody
    @PutMapping(value = "update")
    @ApiOperation(value = "修改", httpMethod = "PUT")
    public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody AdminUser adminUser, Errors errors, HttpServletResponse response) throws Exception {
	  controllerUtils.setTenantInfoByUpdate(adminUser);
        updateAutoEntity(adminUser, response);
    }

    @ResponseBody
    @DeleteMapping(value = "/del/{id}")
    @ApiOperation(value = "删除广告", httpMethod = "DELETE")
    public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
	  removeAutoEntity(id, response);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "获取单个权限", httpMethod = "GET", response = AdminUser.class)
    public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
	  getAutoEntity(id, response);
    }

}
