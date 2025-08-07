package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/all")
    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/jpql/highstock")
    public List<Inventory> getHighStockItemsJPQL() {
        return inventoryRepository.fetchHighStockItems();
    }

    @GetMapping("/native/highstock")
    public List<Inventory> getHighStockItemsNative() {
        return inventoryRepository.fetchHighStockItemsNative();
    }

    @GetMapping("/named-query/sortName")
    public List<Inventory> getSortedByCategory() {
        return inventoryRepository.sortByCategoryIdNamedQuery();
    }

    @GetMapping("/stored-procedure/all")
    @Transactional
    public List<Inventory> getInventoryUsingProcedure() {
        return inventoryRepository.getAllInventory();
    }
}
