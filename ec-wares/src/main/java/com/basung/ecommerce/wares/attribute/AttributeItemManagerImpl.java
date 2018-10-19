package com.basung.ecommerce.wares.attribute;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午2:34
 */

@Transactional
@Service
public class AttributeItemManagerImpl extends GenericServiceImpl<AttributeItem, String, GlobalException> implements AttributeItemManager {

    @Resource
    AttributeItemDao attributeItemDao;

    protected GenericRepository<AttributeItem, String> getRepository(){ return attributeItemDao; }

}
