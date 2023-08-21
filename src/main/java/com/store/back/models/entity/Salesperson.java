package com.store.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salespersons")
public class Salesperson {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salespersonId;

    @Column(name = "salesperson_name")
    private String salespersonName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

	public Long getSalespersonId() {
		return salespersonId;
	}

	public void setSalespersonId(Long salespersonId) {
		this.salespersonId = salespersonId;
	}

	public String getSalespersonName() {
		return salespersonName;
	}

	public void setSalespersonName(String salespersonName) {
		this.salespersonName = salespersonName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    
}
