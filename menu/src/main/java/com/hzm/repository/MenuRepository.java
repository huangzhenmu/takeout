package com.hzm.repository;

import com.hzm.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);
}
