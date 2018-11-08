package com.basung.ecommerce.common.service;

import com.basung.ecommerce.common.entity.CommonEntity;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-06-26
 * Time: 上午11:29
 */
public interface GenericService<T extends CommonEntity, ID extends Serializable, E extends GlobalException> {

    /**
     * 新增或更新
     */
    T save(T t);

    /**
     * 新增或更新
     * 注意数量不要太大，特别是数据迁移时不要使用该方法
     */
    Iterable<T> save(Iterable<T> entities);

    /**
     * 根据ID删除
     */
    void delete(ID id);

    /**
     * 根据实体删除
     */
    void delete(T t);

    /**
     * 根据ID查找对象
     */
    T findById(ID id);


    /**
     * 查询全部
     */
    List<T> findAll();

    /**
     * 根据ID查找对象是否存在
     */
    Boolean existsById(ID id);


    /**
     * 分页排序获取数据
     * 禁止使用该接口进行count操作
     * Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.DESC,"id"));
     *
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);

    /**
     * 多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型 使用时注意避免结果集过大
     *
     * @param params {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @return
     * @author
     */
    List<T> query(Specification params);

    /**
     * 分页多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型
     *
     * @param params   {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @param pageable 分页信息 new PageRequest(page, size,new Sort(Direction.DESC, "updateTime"))
     * @return
     * @author yangwk
     * @time 2017年8月1日 下午3:50:46
     */
    Page<T> query(Specification params, Pageable pageable);

}
