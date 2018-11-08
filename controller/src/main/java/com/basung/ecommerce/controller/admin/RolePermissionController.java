package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.common.controller.ResponseUtils;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.permission.Permission;
import com.basung.ecommerce.permission.PermissionService;
import com.basung.ecommerce.rolePermission.RolePermission;
import com.basung.ecommerce.rolePermission.RolePermissionService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.utils.ControllerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:47
 */

@Api(value = "角色管理接口  平台角色管理", tags = {"角色管理接口  平台角色管理"})
@RestController
@RequestMapping("/admin/rolePermission")
public class RolePermissionController extends AutoEntityController<RolePermission, String, GlobalException, RolePermissionService> {

    private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = rolePermissionService;
    }


    @ApiOperation(value = "新增  权限", notes = "保存  新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody RolePermission rolePermission, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  controllerUtils.setTenantInfoByCreate(rolePermission);

	  addAutoEntity(rolePermission, request, response);
    }

    @ApiOperation(value = "为角色添加权限---传输格式：'1，2，3，4，5，6 ")
    @RequestMapping(value = "/createRolePermission", method = RequestMethod.POST)
    public void add(@ApiParam(value = "对象", required = true) @Validated @RequestParam("roleId") String roleId, @RequestParam("permissions") String permissionIds, HttpServletResponse response) throws Exception {

	  this.rolePermissionService.createRolePermission(roleId, permissionIds);
	  ResponseUtils.writeSuccessResult(response);

    }

    @ResponseBody
    @GetMapping(value = "/getRolePermission/{roleId}")
    @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = RolePermission.class)
    public void get(@ApiParam(value = "获取一个角色的所有权限", required = true) @PathVariable String roleId, HttpServletResponse response) throws Exception {

	  List<Permission> permissionList = this.permissionService.getPermissionsByRoleId(roleId);

	  ResponseUtils.writeSuccessResult(response, permissionList);
    }

}
