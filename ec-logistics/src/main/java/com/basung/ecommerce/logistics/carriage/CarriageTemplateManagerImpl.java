package com.basung.ecommerce.logistics.carriage;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午1:35
 */

@Transactional
@Service
public class CarriageTemplateManagerImpl extends GenericServiceImpl<CarriageTemplate, String, GlobalException> implements CarriageTemplateManager {

    @Resource
    CarriageTemplateDao carriageTemplateDao;

    protected GenericRepository<CarriageTemplate, String> getRepository() {
	  return carriageTemplateDao;
    }

}
