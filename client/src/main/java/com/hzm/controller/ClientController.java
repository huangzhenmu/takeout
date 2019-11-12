package com.hzm.controller;

import com.hzm.entity.Menu;
import com.hzm.entity.MenuVo;
import com.hzm.provider.MenuProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private MenuProvider menuProvider;

    @GetMapping("/findAll")
    @ResponseBody//@Controller注解的类的方法是返回试图，如果直接返回数据，要加@ResponseBody
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;//起始的索引
        return menuProvider.findAll(index,limit);
    }


    //由于用了thymeleaf模板，所以访问时不能直接访问静态文件，要有个跳转
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuProvider.save(menu);
        return "redirect:/account/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") long id, Model model){
        model.addAttribute("list",menuProvider.findAll());
        model.addAttribute("menu",menuProvider.findById(id));
        return "menu_update";
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuProvider.update(menu);
        return "redirect:/account/redirect/menu_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        //orderFeign.deleteByMid(id);
        menuProvider.deleteById(id);
        return "redirect:/account/redirect/menu_manage";
    }
}
