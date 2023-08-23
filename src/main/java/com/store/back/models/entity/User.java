package com.store.back.models.entity;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "username", unique = true)
    private String username;

    @JsonProperty("password")
    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolUser> userRoles;

    @Column(name = "role")
    private String role; // Can be "administrator" or "salesperson"

    @Column(name = "last_access")
    private Date lastAccess;

    @Column(name = "ip_last_access")
    private String ipLastAccess;

	public Long getUserId() {
		return Id;
	}

	public void setUserId(Long Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getIpLastAccess() {
		return ipLastAccess;
	}

	public void setIpLastAccess(String ipLastAccess) {
		this.ipLastAccess = ipLastAccess;
	}
	
	public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
}
