package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Food;
import br.edu.ufsj.tecweb.pigman.Repository.FoodRepository;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        return this.foodRepository.findAll();

    }

    public Food save(Food entity) {
        return this.foodRepository.save(entity);
    }

}
