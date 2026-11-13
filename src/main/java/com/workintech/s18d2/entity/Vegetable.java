package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vegetable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive(message = "ID must be positive")
    private Long id;

    @NotBlank(message = "Vegetable name cannot be empty")
    private String name;

    @Positive(message = "Vegetable price must be greater than zero")
    @NotNull(message = "Price cannot be null")
    private Double price;
    private boolean isGrownOnTree;
}
