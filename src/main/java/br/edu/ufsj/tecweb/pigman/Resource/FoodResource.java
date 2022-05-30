package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufsj.tecweb.pigman.Domain.Food;
import br.edu.ufsj.tecweb.pigman.Service.FoodService;
import br.edu.ufsj.tecweb.pigman.dtos.FoodDTO;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Food>> getById(@PathVariable("id") Long id) {
        try {
            var food = this.foodService.findById(id);
            return ResponseEntity.ok(food);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Food> save(@RequestBody() FoodDTO entityDTO) throws URISyntaxException {
        var food = new Food();
        BeanUtils.copyProperties(entityDTO, food);
        var newFood = this.foodService.save(food);

        return ResponseEntity.created(
                new URI("/foods/" + newFood.getId())).body(newFood);
    }
}
