package com.hzm.services;

import com.hzm.entity.Admin;
import com.hzm.entity.User;

public interface AccountService {
    public User userLogin(String username, String password);
    public Admin adminLogin(String username, String password);
}
