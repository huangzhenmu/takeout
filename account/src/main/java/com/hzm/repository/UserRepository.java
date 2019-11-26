package com.hzm.repository;

import com.hzm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    User login(String username, String password);
}
