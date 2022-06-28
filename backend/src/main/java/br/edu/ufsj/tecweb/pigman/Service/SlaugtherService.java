package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Slaugther;
import br.edu.ufsj.tecweb.pigman.Repository.SlaugtherRepository;

@Service
public class SlaugtherService {
    private final SlaugtherRepository repository;

    public SlaugtherService(SlaugtherRepository slaugtherRepository) {
        this.repository = slaugtherRepository;
    }

    public Slaugther save(Slaugther slaugther) {
        return this.repository.save(slaugther);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
        return;
    }

    public List<Slaugther> findAll() {
        return this.repository.findAll();
    }

    public Optional<Slaugther> findById(Long id) {
        return this.repository.findById(id);
    }
}
