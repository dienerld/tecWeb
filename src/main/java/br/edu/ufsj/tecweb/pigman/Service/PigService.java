package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Repository.PigRepository;

@Service
public class PigService {

    private final PigRepository pigRepository;

    PigService(PigRepository repository) {
        this.pigRepository = repository;
    }

    public List<Pig> findAll() {
        return this.pigRepository.findAll();
    }

    @Transactional()
    public Pig save(Pig entity) {
        return this.pigRepository.save(entity);
    }

    public boolean existsById(Long id) {
        return this.pigRepository.existsById(id);
    }

    @Transactional()
    public void deleteById(Long id) {
        this.pigRepository.deleteById(id);
    }

    public Optional<Pig> findById(Long id) {
        return this.pigRepository.findById(id);
    }

}
