package com.hzm.controller;

import com.hzm.entity.Menu;
import com.hzm.entity.MenuVo;
import com.hzm.entity.Type;
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
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Menu> list = menuService.findAll(index, limit);
        return new MenuVo(200,"成功",menuService.count(),list);
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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuService.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return menuService.findTypes();
    }
}
