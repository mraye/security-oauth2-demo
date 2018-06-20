package com.github.vspro.persistent.dao;

import com.github.vspro.persistent.domain.UserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);

    UserDo queryByUserName(@Param("username") String username);

    List<String> queryUserRoleByUserName(@Param("username") String username);
}