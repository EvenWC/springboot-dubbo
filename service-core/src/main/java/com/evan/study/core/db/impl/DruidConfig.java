package com.evan.study.core.db.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.evan.study.core.db.DataSourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Auther: Administrator
 * @Date: 2018/6/19 16:20
 * @Description: Duird数据源配置
 */
@Configuration
@PropertySource("classpath:db.properties")
public class DruidConfig implements DataSourceConfig {

    @Value("${db.datasource.driverClassName}")
    private String driverClassName;

    @Value("${db.datasource.url}")
    private String url;

    @Value("${db.datasource.username}")
    private String username;

    @Value("${db.datasource.password}")
    private String password;

    @Value("${db.datasource.initialSize:5}")
    private String initialSize;

    @Value("${db.datasource.minIdle:1}")
    private String minIdle;

    @Value("${db.datasource.maxActive:20}")
    private String maxActive;

    @Value("${db.datasource.maxWait:60000}")
    private String maxWait;

    @Value("${db.datasource.timeBetweenEvictionRunsMillis:60000}")
    private String timeBetweenEvictionRunsMillis;

    @Value("${db.datasource.minEvictableIdleTimeMillis:300000}")
    private String minEvictableIdleTimeMillis;

    @Value("${db.datasource.druid.sys.filters:stat}")
    private String filters;

    @Value("${db.datasource.validationQuery:SELECT 1}")
    private String validationQuery;

    @Value("${db.datasource.validationQueryTimeout:3}")
    private String validationQueryTimeout;

    @Value("${db.datasource.testWhileIdle:true}")
    private String testWhileIdle;

    @Value("${db.datasource.testOnBorrow:false}")
    private String testOnBorrow;

    @Value("${db.datasource.testOnReturn:false}")
    private String testOnReturn;

    @Value("${db.datasource.poolPreparedStatements:false}")
    private String poolPreparedStatements;

    @Value("${db.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${db.datasource.useGlobalDataSourceStat:false}")
    private String useGlobalDataSourceStat;

    @Value("${db.monitor.allow}")
    private String allow;

    @Value("${db.monitor.deny}")
    private String deny;

    @Value("${db.monitor.loginUsername}")
    private String loginUsername;

    @Value("${db.monitor.loginPassword}")
    private String loginPassword;

    @Value("${db.monitor.resetEnable}")
    private String resetEnable;

    @Bean("druidDataSource")
    public DataSource getDataSource() throws Exception {
        Properties properties = new Properties() ;
        properties.put("driverClassName",driverClassName);
        properties.put("url",url);
        properties.put("username",username);
        properties.put("password",password);
        properties.put("initialSize",initialSize);
        properties.put("minIdle",minIdle);
        properties.put("maxActive",maxActive);
        properties.put("maxWait",maxWait);
        properties.put("timeBetweenEvictionRunsMillis",timeBetweenEvictionRunsMillis);
        properties.put("minEvictableIdleTimeMillis",minEvictableIdleTimeMillis);
        properties.put("filters",filters);
        properties.put("validationQuery",validationQuery);
        properties.put("validationQueryTimeout",validationQueryTimeout);
        properties.put("testWhileIdle",testWhileIdle);
        properties.put("testOnBorrow",testOnBorrow);
        properties.put("poolPreparedStatements",poolPreparedStatements);
        properties.put("connectionProperties",connectionProperties);
        properties.put("useGlobalDataSourceStat",useGlobalDataSourceStat);
        return DruidDataSourceFactory.createDataSource(properties);
    }
    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //添加初始化参数：initParams
        servletRegistrationBean.addInitParameter("allow",allow);
        servletRegistrationBean.addInitParameter("deny",deny);
        servletRegistrationBean.addInitParameter("loginUsername",loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
        servletRegistrationBean.addInitParameter("resetEnable",resetEnable);
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");

        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
