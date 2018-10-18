package com.basung.ecommerce.loingLog;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-09-下午5:33
 */

@Transactional
@Service
public class LoginLogServiceImpl extends GenericServiceImpl<LoginLog, String, GlobalException> implements LoginLogService{

    @Resource
    LoginLogRepository loginLogRepository;

    protected GenericRepository<LoginLog, String> getRepository() {
	  return loginLogRepository;
    }

}

