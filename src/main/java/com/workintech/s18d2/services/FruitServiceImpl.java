package com.workintech.s18d2.services;


import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Optional<Fruit> findById(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        fruitRepository.deleteById(id);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException("Fruit not found with id: " + id));

        fruitRepository.delete(fruit);

        return fruit;
    }

    @Override
    public long count() {
        return fruitRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return fruitRepository.existsById(id);
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException("Fruit not found with id: " + id));
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}