package com.basung.ecommerce.controller.wares;

import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.utils.ControllerUtils;
import com.basung.ecommerce.wares.goodsSku.GoodsSKU;
import com.basung.ecommerce.wares.goodsSku.GoodsSKUManager;
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
 * Date: 2018-10-19-下午3:13
 */

@Api(value = "商品SKU  商品SKU", tags = { "商品SKU  商品SKU" })
@RestController
@RequestMapping("/wares/sku")
public class GoodsSkuController extends AutoEntityController<GoodsSKU, String, GlobalException, GoodsSKUManager> {

    private final static Logger logger = LoggerFactory.getLogger(GoodsSkuController.class);

    @Autowired
    private GoodsSKUManager goodsSKUManager;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init()
    {
	  this.autoEntityManager = goodsSKUManager;
    }


    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = GoodsSKU.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	  queryAutoEntity(request, response);
    }

    @ApiOperation(value = "新增", notes = "保存  新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody GoodsSKU goodsSKU, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  controllerUtils.setTenantInfoByCreate(goodsSKU);
	  addAutoEntity(goodsSKU, request, response);
    }


    @ResponseBody
    @PutMapping(value = "update")
    @ApiOperation(value = "修改", httpMethod = "PUT")
    public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody GoodsSKU goodsSKU, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  controllerUtils.setTenantInfoByUpdate(goodsSKU);
	  updateAutoEntity(goodsSKU, response);
    }

    @ResponseBody
    @DeleteMapping(value = "/del/{id}")
    @ApiOperation(value = "删除", httpMethod = "DELETE")
    public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
	  removeAutoEntity(id, response);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = GoodsSKU.class)
    public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
	  getAutoEntity(id, response);
    }

}
