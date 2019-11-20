package com.hzm.services;

import com.hzm.entity.Menu;
import com.hzm.entity.Type;

import java.util.List;

public interface MenuService {
    List<Menu> findAll(int index, int limit);
    int count();
    Menu findById(long id);
    void save(Menu menu);
    void update(Menu menu);
    void deleteById(long id);
    List<Type> findTypes();
}
