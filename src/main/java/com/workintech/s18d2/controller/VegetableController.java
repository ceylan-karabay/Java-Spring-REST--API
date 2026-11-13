package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.ResourceNotFoundException;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
@Validated
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll() {
        return vegetableService.findAllByOrderByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable @Positive Long id) {
        return vegetableService.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vegetable not found with id: " + id));
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc() {
        return vegetableService.findAllByOrderByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Valid @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> findByName(@PathVariable String name) {
        return vegetableService.findByNameContaining(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable @Positive Long id) {

        Vegetable vegetable = vegetableService.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vegetable not found with id: " + id));

        vegetableService.delete(vegetable);
    }
}
