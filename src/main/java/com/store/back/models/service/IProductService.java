package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.Product;

public interface IProductService {
	List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
