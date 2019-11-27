package com.hzm.controller;

import com.hzm.entity.Menu;
import com.hzm.entity.MenuVo;
import com.hzm.entity.Type;
import com.hzm.services.impl.MenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(tags = "MenuHandler", description = "菜单管理")
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
    @ApiOperation("获取所有菜品列表")
    public MenuVo findAll(@PathVariable("index")@ApiParam("起点") int index, @PathVariable("limit")@ApiParam("范围") int limit){
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
