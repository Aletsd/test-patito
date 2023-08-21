package com.store.back.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.back.models.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    // You can define custom query methods here if needed
}