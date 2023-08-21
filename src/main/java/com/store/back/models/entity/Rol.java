package com.store.back.models.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(nullable = false, unique = true)
    private String name;

 

    @ManyToMany(mappedBy = "roles")
    private Set<RolUser> users;


    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }

	public Long getId() {
		return rolId;
	}

	public void setId(Long rolId) {
		this.rolId = rolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RolUser> getUsers() {
		return users;
	}

	public void setUsers(Set<RolUser> users) {
		this.users = users;
	}
    
}
