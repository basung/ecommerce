package com.basung.ecommerce.common.service.impl;

import com.basung.ecommerce.common.entity.CommonEntity;
import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.GenericService;
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
 * Time: 下午2:25
 */
public abstract class GenericServiceImpl<T extends CommonEntity, ID extends Serializable, E extends GlobalException> implements GenericService<T, ID, E> {


    protected abstract GenericRepository<T, ID> getRepository();


    @Override
    public T save(T t){
        return this.getRepository().save(t);
    }

    @Override
    public  Iterable<T> save(Iterable<T> entities){
        return this.getRepository().saveAll(entities);
    }

    @Override
    public void delete(ID id){
        this.getRepository().deleteById(id);
    }

    @Override
    public void delete(T t){
        this.getRepository().delete(t);
    }

    @Override
    public T findById(ID id){

        if(this.getRepository().findById(id).isPresent()){
            return this.getRepository().findById(id).get();
        }else {
            return null;
        }
    }

    @Override
    public List<T> findAll(){
        return this.getRepository().findAll();
    }

    @Override
    public Boolean existsById(ID id){
        return this.getRepository().existsById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable){
        return this.getRepository().findAll(pageable);
    }

    @Override
    public  List<T> query(Specification params){
        return this.getRepository().findAll(params);
    }

    @Override
    public Page<T> query(Specification params,Pageable pageable){
        return  this.getRepository().findAll(params,pageable);
    }

}
