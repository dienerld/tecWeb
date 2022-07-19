package br.edu.ufsj.tecweb.pigman.Repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Domain.Stall;

public interface PigRepository extends JpaRepository<Pig, Long> {

    @EntityGraph(attributePaths = { "stall" })
    public Optional<Pig> findOneWithStallById(Long id);

    public List<Pig> findByStall(Stall stall);

}
