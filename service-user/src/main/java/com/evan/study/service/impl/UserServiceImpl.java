package com.evan.study.service.impl;

import com.evan.study.entity.User;
import com.evan.study.mapper.UserMapper;
import com.evan.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Administrator
 * @Date: 2018/6/20 23:01
 * @Description:
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getOneById(id);
    }
}
