package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAll();

}
