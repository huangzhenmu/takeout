package com.hzm.repository;

import com.hzm.entity.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeRepository {
    public Type findById(long id);
}
