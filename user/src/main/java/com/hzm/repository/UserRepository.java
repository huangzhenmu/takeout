package com.hzm.repository;

import com.hzm.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public int count();
    public User findById(long id);
    public void save(User menu);
    public void update(User menu);
    public void deleteById(long id);
}
