package com.hzm.services;

import com.hzm.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll(int index, int limit);
    int count();
    void save(User user);
    void deleteById(long id);
}
