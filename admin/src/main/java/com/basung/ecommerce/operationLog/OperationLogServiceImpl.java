package com.basung.ecommerce.operationLog;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import com.basung.ecommerce.loingLog.LoginLog;
import com.basung.ecommerce.loingLog.LoginLogRepository;
import com.basung.ecommerce.loingLog.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-09-下午5:33
 */

@Transactional
@Service
public class OperationLogServiceImpl extends GenericServiceImpl<OperationLog, String, GlobalException> implements OperationLogService {

    @Resource
    OperationLogRepository operationLogRepository;

    protected GenericRepository<OperationLog, String> getRepository() {
	  return operationLogRepository;
    }

}

