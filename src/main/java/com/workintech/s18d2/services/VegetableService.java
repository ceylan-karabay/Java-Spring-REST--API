package com.workintech.s18d2.services;



import com.workintech.s18d2.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);

    List<Vegetable> findAll();

    Optional<Vegetable> findById(Long id);

    void deleteById(Long id);

    void delete(Vegetable vegetable);

    long count();

    boolean existsById(Long id);

    List<Vegetable> findAllByOrderByPriceDesc();

    List<Vegetable> findAllByOrderByPriceAsc();

    List<Vegetable> findByNameContaining(String name);
}
