package com.example.demo.repository;

import com.example.demo.model.Inventory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    // JPQL: Fetch items where in_stock > 50, ordered by details
    @Query("SELECT i FROM Inventory i WHERE i.inStock > 50 ORDER BY i.description ASC")
    List<Inventory> fetchHighStockItems();

    // Native SQL: Same query in native SQL
    @Query(value = "SELECT * FROM inventory WHERE in_stock > 50 ORDER BY description ASC", nativeQuery = true)
    List<Inventory> fetchHighStockItemsNative();

    // Named Query
   
    @Query(name = "Inventory.sortBySupplierName")
    List<Inventory> sortByCategoryIdNamedQuery();

   
    @Procedure(name = "Inventory.getAllInventory")
    List<Inventory> getAllInventory();
}
