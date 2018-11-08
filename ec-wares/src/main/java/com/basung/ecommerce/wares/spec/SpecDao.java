package com.basung.ecommerce.wares.spec;

import com.basung.ecommerce.common.repository.GenericRepository;

/**
 * Date: 2018-10-19-上午10:51
 */
public interface SpecDao extends GenericRepository<Spec, String> {


    //    @Query(value = " SELECT * FROM bss_admin_user WHERE login_name = ?1 ", nativeQuery = true)
    Spec getBySpecName(String specName);

}
