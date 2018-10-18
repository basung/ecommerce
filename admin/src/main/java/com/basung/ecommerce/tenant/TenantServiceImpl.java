package com.basung.ecommerce.tenant;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午2:28
 */
@Transactional
@Service
public class TenantServiceImpl extends GenericServiceImpl<Tenant, String, GlobalException> implements TenantService {

    @Resource
    TenantRepository tenantRepository;

    protected GenericRepository<Tenant, String> getRepository() {
	  return tenantRepository;
    }

}
