package com.store.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.store.back.models.entity.Order;
import com.store.back.models.entity.OrderStatus;
import com.store.back.models.service.IOrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus newStatus) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            existingOrder.setStatus(newStatus);
            return orderService.updateOrder(existingOrder);
        } else {
            // Handle the case where the order with the given ID does not exist
            // For example, you can throw an exception or return a meaningful response
            return null;
        }
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
