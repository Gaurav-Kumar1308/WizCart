package com.example.inventoryService.service.impl;

import com.example.inventoryService.entity.Inventory;
import com.example.inventoryService.repository.InventoryRepository;
import com.example.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory get(Long id) {
        return inventoryRepository.findById(id).get() ;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
    
}
