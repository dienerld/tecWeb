package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;

public interface StallRepository extends JpaRepository<Stall, Long> {

    // @EntityGraph(attributePaths = { "pigs" })
    // public Stall findStallWithPigsById(Long Id);

    // @Query("select s from Stall s join fetch s.pigs")
    // public List<Stall> findAllStallWithPigs();

    @Query("select s from Stall s join slaughter s.pigs")
    public List<Stall> findAllStallWithLast();

}
