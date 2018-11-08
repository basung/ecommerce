package com.basung.ecommerce.adminUser;

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
public class AdminUserServiceImpl extends GenericServiceImpl<AdminUser, String, GlobalException> implements AdminUserService {

    @Resource
    AdminUserRepository adminUserRepository;

    protected GenericRepository<AdminUser, String> getRepository() {
	  return adminUserRepository;
    }

    public AdminUser getAdminUserByUserName(String userName) {
	  AdminUser adminUser = this.adminUserRepository.getByUserName(userName);
	  return adminUser;
    }

    public AdminUser getAdminUserByUserId(String userId) {

	  AdminUser adminUser = this.adminUserRepository.getAdminUserById(userId);

	  return adminUser;

    }

}
