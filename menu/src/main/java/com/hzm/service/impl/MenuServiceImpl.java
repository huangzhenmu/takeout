package com.hzm.service.impl;

import com.hzm.entity.Menu;
import com.hzm.entity.Type;
import com.hzm.repository.MenuRepository;
import com.hzm.repository.TypeRepository;
import com.hzm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    TypeRepository typeRepository;
    @Override
    public List<Menu> findAll(int index, int limit) {
        return menuRepository.findAll(index,limit);
    }

    @Override
    public int count() {
        return menuRepository.count();
    }

    @Override
    public Menu findById(long id) {
        return  menuRepository.findById(id);
    }

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void update(Menu menu) {
        menuRepository.update(menu);
    }

    @Override
    public void deleteById(long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<Type> findTypes() {
        return typeRepository.findAll();
    }
}
