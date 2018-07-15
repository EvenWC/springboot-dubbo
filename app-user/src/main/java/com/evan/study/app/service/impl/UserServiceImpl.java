package com.evan.study.app.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evan.study.app.service.UserService;
import com.evan.study.dubbo.service.DubboUserService;
import com.evan.study.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 21:27
 * @Description:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Reference(timeout = 35000,interfaceClass = DubboUserService.class)
    private DubboUserService dubboUserService;

    @Override
    public User getUser(Long id) {
        return dubboUserService.getUserById(id);
    }
}
