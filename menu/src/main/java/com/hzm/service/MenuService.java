package com.hzm.service;

import com.hzm.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAll(int index, int limit);
    int count();
    Menu findById(long id);
    void save(Menu menu);
    void update(Menu menu);
    void deleteById(long id);
}
