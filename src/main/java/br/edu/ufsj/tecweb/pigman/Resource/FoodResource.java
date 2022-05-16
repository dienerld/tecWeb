package br.edu.ufsj.tecweb.pigman.Resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufsj.tecweb.pigman.Domain.Food;
import br.edu.ufsj.tecweb.pigman.Service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodResource {

    private FoodService foodService;

    FoodResource(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping()
    public List<Food> getAll() {
        return this.foodService.findAll();
    }
}
