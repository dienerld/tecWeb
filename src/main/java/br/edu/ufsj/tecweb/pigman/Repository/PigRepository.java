package br.edu.ufsj.tecweb.pigman.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;

public interface PigRepository extends JpaRepository<Pig, Long> {

}
