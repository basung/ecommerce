package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.common.controller.*;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.permission.Permission;
import com.basung.ecommerce.permission.PermissionService;
import com.basung.ecommerce.utils.ControllerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:47
 */

@Api(value = "权限管理接口  权限", tags = { "权限管理接口  权限" })
@RestController
@RequestMapping("/admin/permission")
public class PermissionController extends AutoEntityController<Permission, String, GlobalException, PermissionService> {

  @Autowired
  private PermissionService permissionService;

  @Autowired
  private ControllerUtils controllerUtils;

  @PostConstruct
  public void init()
  {
    this.autoEntityManager = permissionService;
  }

  @ResponseBody
  @GetMapping(value = "query")
  @ApiOperation(value = "查询权限列表", httpMethod = "GET", response = Permission.class)
  @RequiresPermissions(value={"permission/query"})
  public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
    queryAutoEntity(request, response);
  }

  @ApiOperation(value = "新增  权限", notes = "保存  新增/修改的  权限")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @RequiresPermissions(value={"permission/create"})
  public void add(@ApiParam(value = "权限对象", required = true) @Validated @RequestBody Permission permission, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {
    controllerUtils.setTenantInfoByCreate(permission);
    addAutoEntity(permission, request, response);
  }


  @ResponseBody
  @PutMapping(value = "update")
  @ApiOperation(value = "修改", httpMethod = "PUT")
  @RequiresPermissions(value={"permission/edit"})
  public void update(@ApiParam(value = "权限对象", required = true) @Validated @RequestBody Permission permission, Errors errors, HttpServletResponse response) throws Exception {
    controllerUtils.setTenantInfoByUpdate(permission);
    updateAutoEntity(permission, response);
  }

  @ResponseBody
  @DeleteMapping(value = "/del/{id}")
  @ApiOperation(value = "删除广告", httpMethod = "DELETE")
  @RequiresPermissions(value={"permission/remove"})
  public void del(@ApiParam(value = "权限标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
    removeAutoEntity(id, response);
  }

  @ResponseBody
  @GetMapping(value = "/get/{id}")
  @ApiOperation(value = "获取单个权限", httpMethod = "GET", response = Permission.class)
  @RequiresPermissions(value={"permission/get"})
  public void get(@ApiParam(value = "权限标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
    getAutoEntity(id, response);
  }

}
