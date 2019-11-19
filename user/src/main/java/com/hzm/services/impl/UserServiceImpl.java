package com.hzm.services.impl;

import com.hzm.entity.User;
import com.hzm.repository.UserRepository;
import com.hzm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll(int index, int limit) {
        return userRepository.findAll(index,limit);
    }

    @Override
    public int count() {
        return userRepository.count();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
