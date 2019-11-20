package com.hzm.services.impl;

import com.hzm.entity.Admin;
import com.hzm.entity.User;
import com.hzm.repository.AdminRepository;
import com.hzm.repository.UserRepository;
import com.hzm.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public User userLogin(String username, String password) {
        return null;
    }

    @Override
    public Admin adminLogin(String username, String password) {
        return null;
    }
}
