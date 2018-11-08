package com.basung.ecommerce.role;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */

@Transactional
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String, GlobalException> implements RoleService {

    @Resource
    RoleRepository roleRepository;

    protected GenericRepository<Role, String> getRepository() {
	  return roleRepository;
    }


}
