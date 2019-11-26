package com.hzm.controller;

import com.hzm.entity.User;
import com.hzm.entity.UserVo;
import com.hzm.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        UserVo userVO = new UserVo();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userService.count());
        userVO.setData(userService.findAll((page-1)*limit,limit));
        return userVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userService.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userService.deleteById(id);
    }
}
