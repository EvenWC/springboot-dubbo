package com.evan.study.dubbo.impl;

import com.evan.study.dubbo.service.DubboUserService;
import com.evan.study.entity.User;
import com.evan.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/6/20 22:30
 * @Description:
 */
@Component
@Service(interfaceClass = DubboUserService.class )
public class DubboUserServiceImpl implements DubboUserService {
    @Autowired
    private UserService userService;

    @Override
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }
}
