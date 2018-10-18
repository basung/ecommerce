package com.basung.ecommerce.shiro;

import com.basung.ecommerce.filter.JWTFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-10-07-下午3:19
 */
@Configuration
public class ShiroConfig {
    /**
     * 先走 filter ，然后 filter 如果检测到请求头存在 token，则用 token 去 login，走 Realm 去验证
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * <p>
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean factory(SecurityManager securityManager) {

	  ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

	  // 添加自己的过滤器并且取名为jwt
	  Map<String, Filter> filterMap = new HashMap<>();

	  //设置我们自定义的JWT过滤器
	  filterMap.put("jwt", new JWTFilter());
	  factoryBean.setFilters(filterMap);
	  factoryBean.setSecurityManager(securityManager);

	  // 设置无权限时跳转的 url;
	  factoryBean.setUnauthorizedUrl("/unauthorized/403");

	  Map<String, String> filterRuleMap = new HashMap<>();

	  //通过http://127.0.0.1:9527/druid/index.html
	  filterRuleMap.put("/druid/**", "anon");

	  //放行登录等接口
	  filterRuleMap.put("/admin/account/login", "anon");
	  filterRuleMap.put("/logout", "anon");

	  //放行webSocket
	  filterRuleMap.put("/api/v1/websocket/*", "anon");

	  //放行swagger
	  filterRuleMap.put("/swagger-ui.html", "anon");
	  filterRuleMap.put("/swagger-resources", "anon");
	  filterRuleMap.put("/v2/api-docs", "anon");
	  filterRuleMap.put("/webjars/springfox-swagger-ui/**", "anon");

	  // 所有请求通过我们自己的JWT Filter
	  filterRuleMap.put("/**", "jwt");

	  // 访问 /unauthorized/** 不通过JWTFilter
	  filterRuleMap.put("/unauthorized/**", "anon");
	  factoryBean.setFilterChainDefinitionMap(filterRuleMap);
	  return factoryBean;
    }

    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager(CustomRealm customRealm) {
	  DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	  // 设置自定义 realm.
	  securityManager.setRealm(customRealm);

	  // 设置shiro 缓存
	  securityManager.setCacheManager(ehCacheManager());

	  /*
	   * 关闭shiro自带的session，详情见文档
	   * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
	   */
	  DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
	  DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
	  defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
	  subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
	  securityManager.setSubjectDAO(subjectDAO);
	  return securityManager;
    }

    /**
     * shiro缓存管理器; 需要注入对应的其它的实体类中:
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager(){
	  EhCacheManager cacheManager = new EhCacheManager();
	  cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
	  return cacheManager;
    }

    /**
     * 添加注解支持
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	  DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
	  // 强制使用cglib，防止重复代理和可能引起代理出错的问题
	  // https://zhuanlan.zhihu.com/p/29161098
	  defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
	  return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
	  AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
	  advisor.setSecurityManager(securityManager);
	  return advisor;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	  return new LifecycleBeanPostProcessor();
    }
}
