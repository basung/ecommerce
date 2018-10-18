package com.basung.ecommerce.common.controller;

import com.basung.ecommerce.common.entity.AutoEntity;
import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.utils.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;

/**
 * Date: 2018-09-29-上午10:07
 */

public abstract class AutoEntityController<T extends AutoEntity, ID extends Serializable, E extends GlobalException, M extends GenericService<T, ID, E>> {


    protected M autoEntityManager;

    private final static Logger logger = LoggerFactory.getLogger(AutoEntityController.class);

    public void addAutoEntity(T autoEntity, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  AutoEntity autoEntity1 = this.autoEntityManager.save(autoEntity);
	  ResponseUtils.writeSuccessResult(response, autoEntity1.getId());

    }

    public void addAutoEntityCustom(T autoEntity, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  AutoEntity autoEntity1 = this.autoEntityManager.save(autoEntity);
	  ResponseUtils.writeSuccessResult(response, autoEntity1);

    }

    public void removeAutoEntity(String id, HttpServletResponse response) throws Exception {

        autoEntityManager.delete((ID) id);
	  ResponseUtils.writeSuccessResult(response);

    }

    public void updateAutoEntity(T autoEntity, HttpServletResponse response) throws Exception {


	  if (this.autoEntityManager.existsById((ID) autoEntity.getId())) {
		ResponseUtils.writeSuccessResult(response, this.autoEntityManager.save(autoEntity));
	  } else {
		ResponseUtils.writeSuccessResult(response);
	  }

    }

    public void getAutoEntity(String id, HttpServletResponse response) throws Exception {

	  AutoEntity autoEntity = this.autoEntityManager.findById((ID) id);
	  if (null == autoEntity) {
		throw new GlobalException(500, "record not existed::记录不存在");
	  }
	  ResponseUtils.writeSuccessResult(response, autoEntity);

    }

    public void queryAutoEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  int pageIndex = 0;  // 分页索引
	  int pageSize = 10;      // 分页大小
	  String desc = "createTime";            //降序字段
	  String asc = "";      //升序字段

	  //获取用户token
	  String token =request.getHeader("Authorization");
	  String adminUserId = "";
	  if(token != null){
		adminUserId = JWTUtil.getUserId(token);
	  }
	  QueryParam queryParam = new QueryParam("tenantId", adminUserId);


	  List<QueryParam> queryParams = new ArrayList();

	  //增加过滤条件,根据登录用户ID，过滤只有该用户创建的数据才可返回。
	  queryParams.add(queryParam);

	  Enumeration names = request.getParameterNames();
	  while (names.hasMoreElements()) {
		String name = (String) names.nextElement();
		String value = request.getParameter(name);
		if ("pageIndex".equalsIgnoreCase(name)) {
		    pageIndex = Integer.parseInt(value);
		} else if ("pageSize".equalsIgnoreCase(name)) {
		    pageSize = Integer.parseInt(value);
		} else if ("desc".equalsIgnoreCase(name)) {
		    desc = value;
		} else if ("asc".equalsIgnoreCase(name)) {
		    asc = value;
		} else if (!this.filterParameter(name, request)) {
		    queryParams.add(new QueryParam(name, value));
		}
	  }

	  Specification<AutoEntity> specification = new Specification<AutoEntity>() {
		@Override
		public javax.persistence.criteria.Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
		    List<javax.persistence.criteria.Predicate> list = new ArrayList<>();
		    for (QueryParam queryParam : queryParams) {
			  logger.info("name === {} ", queryParam.getName());
			  logger.info("value === {} ", queryParam.getValue());
			  String paramName = queryParam.getName();
			  String paramValue = queryParam.getValue();
			  list.add(criteriaBuilder.like(root.get(paramName).as(String.class), String.format("%%%s%%", paramValue)));
		    }
		    javax.persistence.criteria.Predicate[] predicates = new javax.persistence.criteria.Predicate[list.size()];
		    return criteriaBuilder.and(list.toArray(predicates));

		}
	  };

	  //排序定义
//	  Sort sort = new Sort(Sort.Direction.DESC, desc).and(new Sort(Sort.Direction.ASC, asc));
	  Sort sort = new Sort(Sort.Direction.DESC, desc);
	  PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);

	  Page<AutoEntity> list = (Page<AutoEntity>) autoEntityManager.query(specification, pageRequest);
	  PagingResult result = PagingResult.getResult(list.getContent(), list.getTotalElements());

	  result.setPageIndex(pageIndex);
	  result.setPageSize(pageSize);
	  ResponseUtils.writeSuccessPagingResult(response, result);

    }

    protected boolean filterParameter(String name, HttpServletRequest request) {
	  List<String> params = (List) request.getAttribute("FILTER_PARAMETERS");
	  if (params == null) {
		return false;
	  } else {
		Iterator var4 = params.iterator();

		String param;
		do {
		    if (!var4.hasNext()) {
			  return false;
		    }
		    param = (String) var4.next();
		} while (!param.equalsIgnoreCase(name));
		return true;
	  }
    }

    protected static class QueryParam {
	  private String name;
	  private String value;

	  public QueryParam() {
		this((String) null, (String) null);
	  }

	  public QueryParam(String name, String value) {
		this.name = name;
		this.value = value;
		if (this.name != null) {
		    this.name = this.name.trim();   //消除空格
		}

		if (this.value != null) {
		    this.value = this.value.trim();   //消除空格
		}

	  }

	  public String getName() {
		return this.name;
	  }

	  public void setName(String name) {
		this.name = name;
		if (this.name != null) {
		    this.name = this.name.trim();
		}

	  }

	  public String getValue() {
		return this.value;
	  }

	  public void setValue(String value) {
		this.value = value;
		if (this.value != null) {
		    this.value = this.value.trim();
		}

	  }
    }

}
