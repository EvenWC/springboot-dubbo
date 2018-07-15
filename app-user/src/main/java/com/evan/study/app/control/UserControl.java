package com.evan.study.app.control;

import com.evan.study.app.service.UserService;
import com.evan.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 21:24
 * @Description:
 */
@RestController
public class UserControl {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(Long id){
        return userService.getUser(id);
    }



}
