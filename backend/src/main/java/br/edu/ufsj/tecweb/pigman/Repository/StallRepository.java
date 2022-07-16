package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;

public interface StallRepository extends JpaRepository<Stall, Long> {

    Optional<Stall> findByName(String name);

}
