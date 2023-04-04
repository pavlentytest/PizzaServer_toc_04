package com.example.demo;

import org.springframework.data.repository.CrudRepository;

// CRUD - Create Read Update Delete

public interface PizzaRepository extends CrudRepository<Pizza,Integer> {
    // можно не заполнять
}
