package com.hzm.repository;


import com.hzm.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
    Admin login(String username, String password);
}
