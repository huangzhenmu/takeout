package com.hzm.provider;

import com.hzm.entity.User;
import com.hzm.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserProvider {
    @GetMapping("/user/findAll/{page}/{limit}")
    public UserVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
