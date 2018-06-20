package com.github.vspro.persistent.dao;

import com.github.vspro.persistent.domain.AuthorityDo;

public interface AuthorityMapper {
    int insert(AuthorityDo record);

    int insertSelective(AuthorityDo record);
}