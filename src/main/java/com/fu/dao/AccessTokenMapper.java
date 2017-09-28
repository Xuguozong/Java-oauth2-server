package com.fu.dao;

import com.fu.entity.AccessToken;

public interface AccessTokenMapper {
    int deleteByPrimaryKey(Long authId);

    int insert(AccessToken record);

    int insertSelective(AccessToken record);

    AccessToken selectByPrimaryKey(Long authId);

    int updateByPrimaryKeySelective(AccessToken record);

    int updateByPrimaryKey(AccessToken record);
}