package br.edu.ufsj.tecweb.pigman.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;

public interface StallRepository extends JpaRepository<Stall, Long> {

    // @EntityGraph(attributePaths = { "pigs" })
    // public Stall findStallWithPigsById(Long Id);

    // @Query("select s from Stall s join fetch s.pigs")
    // public List<Stall> findAllStallWithPigs();

}
