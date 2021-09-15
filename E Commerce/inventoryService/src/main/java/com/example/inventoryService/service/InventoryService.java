package com.example.inventoryService.service;

import com.example.inventoryService.entity.Inventory;

public interface InventoryService {

    public Inventory get(Long id);
    public Inventory save(Inventory inventory);
    public Inventory update(Inventory inventory);
    public void delete(Long id);
}
