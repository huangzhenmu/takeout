package com.hzm.controller;

import com.hzm.entity.User;
import com.hzm.entity.UserVo;
import com.hzm.provider.OrderProvider;
import com.hzm.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserProvider userProvider;
    @Autowired
    private OrderProvider orderProvider;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return userProvider.findAll(page, limit);
    }

    @PostMapping("/save")
    public String save(User user){
        userProvider.save(user);
        return "redirect:/account/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        orderProvider.deleteByUid(id);
        userProvider.deleteById(id);
        return "redirect:/account/redirect/user_manage";
    }
}
