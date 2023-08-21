package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.Order;

public interface IOrderService {
	List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
