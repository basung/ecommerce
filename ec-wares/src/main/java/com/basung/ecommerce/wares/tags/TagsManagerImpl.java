package com.basung.ecommerce.wares.tags;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:01
 */

@Transactional
@Service
public class TagsManagerImpl extends GenericServiceImpl<Tags, String, GlobalException> implements TagsManager {

    @Resource
    TagsDao tagsDao;

    protected GenericRepository<Tags, String> getRepository() {
	  return tagsDao;
    }

}
