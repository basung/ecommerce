package com.basung.ecommerce.controller.wares;

import com.basung.ecommerce.common.controller.AutoEntityController;
import com.basung.ecommerce.common.controller.ResponseUtils;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.utils.ControllerUtils;
import com.basung.ecommerce.wares.attribute.AttributeManager;
import com.basung.ecommerce.wares.goods.Goods;
import com.basung.ecommerce.wares.goods.GoodsManager;
import com.basung.ecommerce.wares.goodsImage.GoodsImageManager;
import com.basung.ecommerce.wares.goodsSku.GoodsSKUManager;
import com.basung.ecommerce.wares.goodsTags.GoodsTagsManager;
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
 * Date: 2018-10-19-下午3:15
 */

@Api(value = "商品  商品", tags = {"商品  商品"})
@RestController
@RequestMapping("/wares/goods")
public class GoodsController extends AutoEntityController<Goods, String, GlobalException, GoodsManager> {

    private final static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsManager goodsManager;

//    @Autowired
//    private GoodsSKUManager goodsSKUManager;
//
//    @Autowired
//    private GoodsTagsManager goodsTagsManager;
//
//    @Autowired
//    private GoodsImageManager goodsImageManager;
//
//    @Autowired
//    private AttributeManager attributeManager;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = goodsManager;
    }


    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = Goods.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  queryAutoEntity(request, response);
    }

    @ApiOperation(value = "新增", notes = "保存  新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody Goods goods, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  controllerUtils.setTenantInfoByCreate(goods);
	  Goods goods1 = goodsManager.createGoods(goods);
	  ResponseUtils.writeSuccessResult(response, goods1.getId());

    }

    @ResponseBody
    @PutMapping(value = "update")
    @ApiOperation(value = "修改", httpMethod = "PUT")
    public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody Goods goods, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  if (goodsManager.existsById(goods.getId())) {
//            String goodsId = goods.getId();
//		// 1、删除相关联的图片
//		if (goodsImageManager.existsByGoodsId(goodsId)) {
//		    goodsImageManager.removeByGoodsId(goodsId);
//		}
//
//		// 2、删除相关联的商品扩展属性
//		if (attributeManager.existsByGoodsId(goodsId)) {
//		    attributeManager.removeByGoodsId(goodsId);
//		}
//
//		// 3、删除相关联的tags
//		if (goodsTagsManager.existsByGoodsId(goodsId)) {
//		    goodsTagsManager.removeByGoodsId(goodsId);
//		}
//
//		// 4、删除相关联的SKU
//		if (goodsSKUManager.existsByGoodsId(goodsId)) {
//		    goodsSKUManager.removeByGoodsId(goodsId);
//		}

		controllerUtils.setTenantInfoByUpdate(goods);
		Goods goods1 = goodsManager.updateGoods(goods);
		ResponseUtils.writeSuccessResult(response, goods1.getId());
	  } else {
		ResponseUtils.writeErrorResult(response, 400, "记录不存在!!!");
	  }

    }

    @ResponseBody
    @DeleteMapping(value = "/del/{id}")
    @ApiOperation(value = "删除", httpMethod = "DELETE")
    public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
	  removeAutoEntity(id, response);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = Goods.class)
    public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
	  getAutoEntity(id, response);
    }
}
