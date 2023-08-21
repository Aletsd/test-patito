package com.store.back.models.service;

import java.util.List;

import com.store.back.models.entity.Store;

public interface IStoreService {
    List<Store> getAllStores();
    Store getStoreById(Long id);
    Store createStore(Store store);
    Store updateStore(Store store);
    void deleteStore(Long id);
}
