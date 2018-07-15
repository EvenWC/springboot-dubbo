package com.evan.study.core.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Auther: Administrator
 * @Date: 2018/6/19 21:16
 * @Description:
 */
public interface MybatisConfig {
    /**
     * 获取回话工厂
     */
    SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) throws IOException;

    /**
     * 配置事物管理器
     */
    PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource);

    /**
     * 会话模板
     * @return
     */
    SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory);
    /**
     *  获取mapper配置对象，自动扫描工程获取全部Mapper实例
     * @return
     */
    MapperScannerConfigurer getMapperScannerConfigurer();
}
