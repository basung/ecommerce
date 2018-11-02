package com.basung.ecommerce.wares.spec;

import com.basung.ecommerce.common.service.GenericService;
import com.basung.ecommerce.exception.GlobalException;

/**
 * Date: 2018-10-19-上午10:52
 */
public interface SpecManager extends GenericService<Spec, String, GlobalException> {

    /**
     * 创建规格，同时创建相应的规格项
     * @param spec
     * @return spec
     * @throws GlobalException
     */
    Spec createSpec(Spec spec) throws GlobalException;


    /**
     * 更新规格,先删除再创建
     * @param spec
     * @return
     * @throws GlobalException
     */
    Spec updateSpec(Spec spec) throws GlobalException;





}
