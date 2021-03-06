package com.hzm.controller;

import com.hzm.entity.Menu;
import com.hzm.repository.MenuRepository;
import com.hzm.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuServiceImpl menuService;
    @GetMapping("/index")
    public String index(){
        return "menu端口:"+port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return menuService.findAll(index,limit);
    }
    @GetMapping("/count")
    public int count(){
        return menuService.count();
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuService.save(menu);
    }

    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
        menuService.update(menu);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuService.deleteById(id);
    }
}
