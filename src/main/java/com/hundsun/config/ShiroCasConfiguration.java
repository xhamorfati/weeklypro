package com.hundsun.config;


import org.apache.shiro.cache.MemoryConstrainedCacheManager;

import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroCasConfiguration {
//    private static final String casFilterUrlPattern = "/shiro-cas";
    private static final String casFilterUrlPattern = "/";
    private static final Logger logger = LoggerFactory.getLogger(ShiroCasConfiguration.class);

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        //可以自己灵活的定义很多，避免一些根本不需要被Shiro处理的请求被包含进来
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Value("${shiro.cas}") String casServerUrlPrefix,
                                                                  @Value("${shiro.server}") String shiroServerUrlPrefix) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        CasRealm casRealm = new CasRealm();
        casRealm.setDefaultRoles("ROLE_USER");
        casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
        casRealm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);

//        casRealm.setCasService(shiroServerUrlPrefix );
        securityManager.setRealm(casRealm);
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
//        如果要使用面登录的功能，需要添加该类CasSubjectFactory
        securityManager.setSubjectFactory(new CasSubjectFactory());
        return securityManager;
    }


    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put(casFilterUrlPattern, "casFilter");
//        authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器
        // 此处将logout页面设置为anon，而不是logout，因为logout被单点处理，而不需要再被shiro的logoutFilter进行拦截
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "anon");

//       登录成功不拦截
        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }

    /**
     * CAS Filter
     */
    @Bean(name = "casFilter")
    public MyCasFilter getCasFilter(@Value("${shiro.cas}") String casServerUrlPrefix,
                                  @Value("${shiro.server}") String shiroServerUrlPrefix) {
        MyCasFilter casFilter = new MyCasFilter();
        casFilter.setName("casFilter");
        casFilter.setEnabled(true);
        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
//        将成功页面交给casFilter
//        casFilter.setSuccessUrl("/");
        casFilter.setFailureUrl(loginUrl);
        return casFilter;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager,
                                                            MyCasFilter casFilter,
                                                            @Value("${shiro.cas}") String casServerUrlPrefix,
                                                            @Value("${shiro.server}") String shiroServerUrlPrefix) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix ;
//        String loginUrl = shiroServerUrlPrefix ;

        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/homepage");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        Map<String, Filter> filters = new HashMap<>();
//        添加casFilter中，注意，casFilter需要放到shiroFilter的前面
        filters.put("casFilter", casFilter);

        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl(casServerUrlPrefix + "/logout?service=" + shiroServerUrlPrefix);
        filters.put("logout",logoutFilter);
        filters.put("authc", new ShiroFilter());
        loadShiroFilterChain(shiroFilterFactoryBean);
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }
}
