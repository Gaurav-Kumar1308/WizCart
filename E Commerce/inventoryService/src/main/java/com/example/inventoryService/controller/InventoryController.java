package com.example.inventoryService.controller;

import com.example.inventoryService.dto.InventoryDto;
import com.example.inventoryService.entity.Inventory;
import com.example.inventoryService.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController   //This is one additional behaviour(aspect)
@RequestMapping(value = "/inventory/db")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    @GetMapping("/display")
    public String display(){
        return "Inventory Display";
    }
    @GetMapping(value = "/{id}")
    public InventoryDto get(@PathVariable(name = "id") Long id) {
        Inventory inventory = inventoryService.get(id);
        if (inventory == null) {
            return null;
        }
        InventoryDto inventoryDto = new InventoryDto();
        BeanUtils.copyProperties(inventory, inventoryDto);
        return inventoryDto;
    }


    @PostMapping
    public InventoryDto save(@RequestBody Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        BeanUtils.copyProperties(inventory, inventoryDto);
        Inventory savedInventory = inventoryService.save(inventory);
        InventoryDto savedInventoryDto = new InventoryDto();
        BeanUtils.copyProperties(savedInventory, savedInventoryDto);
        kafkaTemplate.send("new_inventory",savedInventory);
        return savedInventoryDto;
    }

    @PutMapping
    public InventoryDto update(@RequestBody InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(inventoryDto, inventory);

        Inventory updatedInventory = inventoryService.update(inventory);

        InventoryDto updatedInventoryDto = new InventoryDto();
        BeanUtils.copyProperties(updatedInventory, updatedInventoryDto);
        kafkaTemplate.send("update_inventory",updatedInventory);
        return updatedInventoryDto;

    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        inventoryService.delete(id);

    }
}
