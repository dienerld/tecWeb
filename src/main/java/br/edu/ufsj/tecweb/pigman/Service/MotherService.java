package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Mother;
import br.edu.ufsj.tecweb.pigman.Repository.MotherRepository;

@Service
public class MotherService {
    private final MotherRepository repository;

    MotherService(MotherRepository repository) {
        this.repository = repository;
    }

    public List<Mother> findAll() {
        return this.repository.findAll();
    }

    public Optional<Mother> findById(Long id) {
        return this.repository.findById(id);
    }

    public Mother save(Mother newMother) {
        return this.repository.save(newMother);
    }

}
