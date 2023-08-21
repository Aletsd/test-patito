package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
