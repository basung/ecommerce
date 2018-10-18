package com.basung.ecommerce.article.news;

import com.basung.ecommerce.common.repository.GenericRepository;
import com.basung.ecommerce.common.service.impl.GenericServiceImpl;
import com.basung.ecommerce.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-18-下午4:20
 */

@Transactional
@Service
public class NewsServiceImpl extends GenericServiceImpl<News, String, GlobalException> implements NewsService {


    @Resource
    NewsRepository newsRepository;

    protected GenericRepository<News, String> getRepository() {
	  return newsRepository;
    }

}
