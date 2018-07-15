package com.evan.study.core.db;

import javax.sql.DataSource;

/**
 * @Auther: Administrator
 * @Date: 2018/6/19 16:18
 * @Description: 抽象的数据源配置接口
 */
public interface DataSourceConfig {
    /**
     * 获取一个数据源
     * @return 数据源对象
     */
    DataSource getDataSource() throws Exception;

    }
