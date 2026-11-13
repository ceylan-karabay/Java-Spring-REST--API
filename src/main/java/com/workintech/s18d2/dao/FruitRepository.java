package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    // Fiyata göre azalan sıralama
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    // Fiyata göre artan sıralama
    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    // İsme göre arama
    @Query("SELECT f FROM Fruit f WHERE f.name LIKE CONCAT('%', :name, '%')")
    List<Fruit> searchByName(@Param("name") String name);
}