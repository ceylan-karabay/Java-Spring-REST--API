package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    // Ücrete göre azalan sıralama
    List<Vegetable> findAllByOrderByPriceDesc();

    // Ücrete göre artan sıralama
    List<Vegetable> findAllByOrderByPriceAsc();

    // İsmi içerisinde gönderilen parametre geçen kayıtlar
    List<Vegetable> findByNameContaining(String name);


}
