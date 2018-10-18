package com.basung.ecommerce;

import com.basung.ecommerce.adminUser.AdminUserService;
import com.basung.ecommerce.role.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Date: 2018-10-11-下午1:02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {


    @Autowired
    AdminUserService adminUserService;

    @Autowired
    RoleService roleService;

    @Test
    public void adminUserServiceTest() {

//	  AdminUser adminUser = new AdminUser();
//	  adminUser.setLoginName("admin");
//	  adminUser.setSalt(MD5.getRandomSalt(5));
//	  adminUser.setPassword(MD5.md5("123456", adminUser.getSalt()));
//	  adminUser.setAssociatedType("superAdmin");
//	  adminUser.setAvatar("http://wx1.sinaimg.cn/orj360/006");
//	  adminUser.setIsActive((byte) 1);
//	  adminUser.setIsDel((byte) 0);
//	  adminUser.setCreator("system_admin");
//	  adminUser.setModifier("system_admin");
//	  adminUser.setTenantId("tenant_id");
//	  adminUser.setEmail("rocky.wang@basung.com");
//	  adminUser.setMobile("15000526290");
//	  adminUser.setTelephone("400-1234-5678");
//	  adminUser.setRoleId("20000-00001");
//	  adminUser.setSex(1);
//	  adminUser.setTrueName("王洋");
//	  adminUserService.save(adminUser);

    }


    @Test
    public void roleServiceTest() {

//        Role role = new Role("系统管理员", "系统管理员,拥有所有权限");
//	  role.setCreator("system_admin");
//	  role.setModifier("system_admin");
//	  role.setTenantId("tenant_id");
//	  role.setIsActive((byte) 1);
//	  role.setIsDel((byte) 0);
//	  roleService.save(role);

    }


}