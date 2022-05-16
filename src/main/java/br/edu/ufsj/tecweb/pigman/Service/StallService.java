package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import br.edu.ufsj.tecweb.pigman.Repository.StallRepository;

@Service
public class StallService {
    private StallRepository repository;

    StallService(StallRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Stall save(Stall newStall) {
        return this.repository.save(newStall);
    }

    public List<Stall> findAll() {
        return this.repository.findAll();
    }

}
