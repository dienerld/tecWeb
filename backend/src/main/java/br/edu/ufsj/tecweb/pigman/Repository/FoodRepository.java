package br.edu.ufsj.tecweb.pigman.Repository;

import br.edu.ufsj.tecweb.pigman.Domain.Food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
