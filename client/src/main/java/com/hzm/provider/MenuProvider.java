package com.hzm.provider;

import com.hzm.entity.Menu;
import com.hzm.entity.MenuVo;
import com.hzm.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")//feign遵循负载均衡的算法从eureka那里获取名称为menu的服务
public interface MenuProvider {

    //由于feign只是获取了menu服务，即获取了端口，但没有映射，所以下面的路径还要加上menu
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/menu/findAll")
    public List<Type> findAll();

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    public void update(@RequestBody Menu menu);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
