package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;

public interface PigRepository extends JpaRepository<Pig, Long> {

    @EntityGraph(attributePaths = { "stall" })
    public Optional<Pig> findOneWithStallById(Long id);

    @Query("select p from Pig p join stall s on p.stall.id = s.id where s.id = ?2 and p.id = ?1")
    public Optional<Pig> findByIdAndStall(Long idPig, String nameStall);

}
