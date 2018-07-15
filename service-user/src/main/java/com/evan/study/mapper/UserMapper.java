package com.evan.study.mapper;

import com.evan.study.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Administrator
 * @Date: 2018/6/19 19:55
 * @Description:
 */
public interface UserMapper {

    User getOneById(@Param("id") Long id);

}
