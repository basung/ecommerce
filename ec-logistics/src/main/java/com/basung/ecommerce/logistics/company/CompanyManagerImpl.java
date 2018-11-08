package com.basung.ecommerce.logistics.company;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午12:45
 */
@Transactional
@Service
public class CompanyManagerImpl extends GenericServiceImpl<Company, String, GlobalException> implements CompanyManager {

    @Resource
    CompanyDao companyDao;

    protected GenericRepository<Company, String> getRepository() {
	  return companyDao;
    }
}
