package com.hzm.controller;

import com.hzm.entity.Order;
import com.hzm.entity.OrderVO;
import com.hzm.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdeHandler {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderService.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderService.countByUid(uid));
        orderVO.setData(orderService.findAllByUid(uid,(page-1)*limit,limit));
        return orderVO;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderService.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid){
        orderService.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderService.countByState(0));
        orderVO.setData(orderService.findAllByState(0,(page-1)*limit,limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid){
        orderService.updateState(id,aid,state);
    }
}
