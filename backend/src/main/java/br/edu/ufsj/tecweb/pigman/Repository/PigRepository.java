package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;

public interface PigRepository extends JpaRepository<Pig, Long> {

    @EntityGraph(attributePaths = { "stall" })
    public Optional<Pig> findOneWithStallById(Long id);

    @Query("select p from Pig p join fetch p.stall where p.id = ?1 and p.stall.name = ?2")
    public Optional<Pig> findByIdAndStall(Long idPig, String nameStall);

}
