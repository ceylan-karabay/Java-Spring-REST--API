package com.workintech.s18d2.services;


import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findByNameContaining(String name) {
        return vegetableRepository.findByNameContaining(name);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Optional<Vegetable> findById(Long id) {
        return vegetableRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }

    @Override
    public long count() {
        return vegetableRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return vegetableRepository.existsById(id);
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceDesc() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceAsc() {
        return List.of();
    }
}
