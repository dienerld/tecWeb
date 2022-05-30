package br.edu.ufsj.tecweb.pigman.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Mother;

public interface MotherRepository extends JpaRepository<Mother, Long> {

}
