package com.store.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "HAWA", unique = true)
    private String hawa;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "discount")
    private double discount;

    @Column(name = "stock")
    private int stock;

    @Column(name = "name_product", nullable = true)
    private String name;
    
    @Column(nullable = true)
    private String description;

    public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getHawa() {
		return hawa;
	}

	public void setHawa(String hawa) {
		this.hawa = hawa;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
