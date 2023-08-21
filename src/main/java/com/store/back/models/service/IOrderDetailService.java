package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.OrderDetail;

public interface IOrderDetailService {
	List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(Long id);
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long id);
}
