package com.github.vspro.persistent.manager;

import com.github.vspro.persistent.dao.UserMapper;
import com.github.vspro.persistent.domain.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created  on 2018/6/20.
 */

@Component
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    public UserDo queryByUserName(String username){
        return userMapper.queryByUserName(username);
    }

    public List<String> queryUserRoleByUserName(String username){
        return userMapper.queryUserRoleByUserName(username);
    }




}
