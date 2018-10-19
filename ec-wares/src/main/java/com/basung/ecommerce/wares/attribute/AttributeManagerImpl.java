package com.basung.ecommerce.wares.attribute;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午2:30
 */

@Transactional
@Service
public class AttributeManagerImpl extends GenericServiceImpl<Attribute, String, GlobalException> implements AttributeManager {

    @Resource
    AttributeDao attributeDao;

    protected GenericRepository<Attribute, String> getRepository(){ return attributeDao; }
}
