package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    Fruit save(Fruit fruit);

    Fruit getById(Long id);

    List<Fruit> findAll();

    Optional<Fruit> findById(Long id);

    void deleteById(Long id);

    Fruit delete(Long id);

    long count();

    boolean existsById(Long id);

    List<Fruit> getByPriceDesc();

    List<Fruit> getByPriceAsc();

    List<Fruit> searchByName(String name);
}
