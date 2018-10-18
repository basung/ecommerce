package com.basung.ecommerce.controller.admin;

import com.basung.ecommerce.role.Role;
import com.basung.ecommerce.role.RoleService;
import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.exception.GlobalException;
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

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:47
 */

@Api(value = "角色管理接口  平台角色管理", tags = { "角色管理接口  平台角色管理" })
@RestController
@RequestMapping("/admin/role")
public class RoleController extends AutoEntityController<Role, String, GlobalException, RoleService> {

  private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

  @Autowired
  private RoleService roleService;

  @Autowired
  private ControllerUtils controllerUtils;

  @PostConstruct
  public void init()
  {
    this.autoEntityManager = roleService;
  }


  @ResponseBody
  @GetMapping(value = "query")
  @ApiOperation(value = "查询列表", httpMethod = "GET", response = Role.class)
  public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    queryAutoEntity(request, response);
  }

  @ApiOperation(value = "新增  权限", notes = "保存  新增")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody Role role, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

    controllerUtils.setTenantInfoByCreate(role);

    logger.info(" role ==== {} ", role.toString());

    addAutoEntity(role, request, response);
  }


  @ResponseBody
  @PutMapping(value = "update")
  @ApiOperation(value = "修改", httpMethod = "PUT")
  public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody Role role, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

    controllerUtils.setTenantInfoByUpdate(role);

    logger.info(" role ==== {} ", role.toString());

    updateAutoEntity(role, response);
  }

  @ResponseBody
  @DeleteMapping(value = "/del/{id}")
  @ApiOperation(value = "删除", httpMethod = "DELETE")
  public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
    removeAutoEntity(id, response);
  }

  @ResponseBody
  @GetMapping(value = "/get/{id}")
  @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = Role.class)
  public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
    getAutoEntity(id, response);
  }

}
