package com.hzm.services.impl;

import com.hzm.entity.Order;
import com.hzm.repository.OrderRepository;
import com.hzm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAllByUid(long uid, int index, int limit) {
        return orderRepository.findAllByUid(uid,index,limit);
    }

    @Override
    public int countByUid(long uid) {
        return orderRepository.countByUid(uid);
    }

    @Override
    public void deleteByMid(long mid) {
        orderRepository.deleteByMid(mid);
    }

    @Override
    public void deleteByUid(long uid) {
        orderRepository.deleteByUid(uid);
    }

    @Override
    public List<Order> findAllByState(int state, int index, int limit) {
        return orderRepository.findAllByState(state,index,limit);
    }

    @Override
    public int countByState(int state) {
        return orderRepository.countByState(state);
    }

    @Override
    public void updateState(long id, long aid, int state) {
        orderRepository.updateState(id,aid,state);
    }
}
