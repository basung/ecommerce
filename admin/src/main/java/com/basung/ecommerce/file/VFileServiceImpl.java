package com.basung.ecommerce.file;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午2:51
 */

@Transactional
@Service
public class VFileServiceImpl extends GenericServiceImpl<VFile, String, GlobalException> implements VFileService {

    @Resource
    VFileRepository vFileRepository;

    protected GenericRepository<VFile, String> getRepository() {
	  return vFileRepository;
    }

}
