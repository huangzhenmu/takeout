package com.hzm.services;

import com.hzm.entity.Order;

import java.util.List;

public interface OrderService {
    public void save(Order order);
    public List<Order> findAllByUid(long uid, int index, int limit);
    public int countByUid(long uid);
    public void deleteByMid(long mid);
    public void deleteByUid(long uid);
    public List<Order> findAllByState(int state, int index, int limit);
    public int countByState(int state);
    public void updateState(long id, long aid, int state);
}
