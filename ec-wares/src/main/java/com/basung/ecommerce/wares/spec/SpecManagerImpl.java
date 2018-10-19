package com.basung.ecommerce.wares.spec;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:53
 */

@Transactional
@Service
public class SpecManagerImpl  extends GenericServiceImpl<Spec, String, GlobalException> implements SpecManager {

    @Resource
    SpecDao specDao;

    protected GenericRepository<Spec, String> getRepository(){ return specDao; }

}
