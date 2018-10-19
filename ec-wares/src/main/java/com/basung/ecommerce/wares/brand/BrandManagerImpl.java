package com.basung.ecommerce.wares.brand;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:13
 */

@Transactional
@Service
public class BrandManagerImpl extends GenericServiceImpl<Brand, String, GlobalException> implements BrandManager {

    @Resource
    BrandDao brandDao;

    protected GenericRepository<Brand, String> getRepository(){ return brandDao; }
}
