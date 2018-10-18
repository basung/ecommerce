package com.basung.ecommerce.article.category;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午4:01
 */

@Transactional
@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, String, GlobalException> implements CategoryService {

    @Resource
    CategoryRepository categoryRepository;

    protected GenericRepository<Category, String> getRepository() {
	  return categoryRepository;
    }
}
