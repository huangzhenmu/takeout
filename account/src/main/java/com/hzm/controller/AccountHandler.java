package com.hzm.controller;

import com.hzm.entity.Account;
import com.hzm.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountServiceImpl accountService;
    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Account account = null;
        switch (type){
            case "user":
                account = accountService.userLogin(username, password);
                break;
            case "admin":
                account = accountService.adminLogin(username, password);
                break;
        }
        return account;
    }
}
