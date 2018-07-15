package com.evan.study.core.db.impl;

import com.evan.study.core.db.MybatisConfig;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: Administrator
 * @Date: 2018/6/19 21:17
 * @Description:
 */
@Configuration
public class MybatisMapperConfig implements MybatisConfig {
    private static final String BASE_PACKAGE = "com.evan.study.**.mapper";

    private static final String MAPPER_LOCATION = "classpath:com/evan/study/**/mapper/*.xml";

    private static final String SQL_SESSION_FACTORY = "sqlSessionFactoryBean";

    private static final String SQL_SESSION_TEMPLATE = "sqlSessionTemplate";

    private static final String ALIASES_PACKAGE = "com.evan.study.entity";

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(ALIASES_PACKAGE);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION);
        sqlSessionFactoryBean.setMapperLocations(resources);
        //添加分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(@Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage(BASE_PACKAGE);
        scannerConfigurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY);
        scannerConfigurer.setSqlSessionTemplateBeanName(SQL_SESSION_TEMPLATE);
        return scannerConfigurer;
    }
}
