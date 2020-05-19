package com.asa.coffee.controller;

import com.asa.coffee.domain.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CoffeeController {

    @GetMapping("/list")
    public List<Coffee> getAllCoffees(){

        List<Coffee> coffees = new ArrayList<Coffee>();

        coffees.add(new Coffee("Colombia", 8, new Date()));
        coffees.add(new Coffee("Guatemala", 5, new Date()));

        return coffees;
    }

}
