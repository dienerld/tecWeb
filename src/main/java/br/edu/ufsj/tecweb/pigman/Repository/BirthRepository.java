package br.edu.ufsj.tecweb.pigman.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufsj.tecweb.pigman.Domain.Birth;

public interface BirthRepository extends JpaRepository<Birth, Long> {

}
