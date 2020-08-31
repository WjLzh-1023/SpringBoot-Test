package com.util;


import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig {

    //shiro过滤器工厂
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean fac = new ShiroFilterFactoryBean();
        fac.setSecurityManager(securityManager);
        fac.setLoginUrl("/login.html");
        fac.setUnauthorizedUrl("/unauth.html");
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roleOrFilter", new RoleFilter());
        fac.setFilters(filterMap);
        Map<String, String> map = new LinkedHashMap<>();
        //map中添加键值对网页及权限/过滤
        map.put("/login.html*", "anon");
        map.put("/user/login*", "anon");
        map.put("/css/**", "anon");
        map.put("/img/**", "anon");
        map.put("/js/**", "anon");
        map.put("/plugins/**", "anon");
        map.put("/admin/emp.html*", "roleOrFilter[admin,manager]");
        map.put("/admin/role.html*", "perms[emp:del]");
        map.put("/**", "authc");
        fac.setFilterChainDefinitionMap(map);
        return fac;
    }

    @Bean
    public LifecycleBeanPostProcessor get() {
        return new LifecycleBeanPostProcessor();

    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Myrealm myrealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myrealm);
        return securityManager;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;

    }

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.put("org.apache.shiro.authz.UnauthorizedException", "/unauth.html");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }


}
