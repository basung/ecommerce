package com.basung.ecommerce.wares.category;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:21
 */

@Transactional
@Service
public class CategoryManagerImpl extends GenericServiceImpl<Category, String, GlobalException> implements CategoryManager {

    @Resource
    CategoryDao categoryDao;

    protected GenericRepository<Category, String> getRepository() {
	  return categoryDao;
    }

}
