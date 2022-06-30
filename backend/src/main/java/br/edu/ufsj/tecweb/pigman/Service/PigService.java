package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Repository.PigRepository;

@Service
public class PigService {

    private final PigRepository repository;

    PigService(PigRepository repository) {
        this.repository = repository;
    }

    public List<Pig> findAll() {
        return this.repository.findAll();
    }

    @Transactional()
    public Pig save(Pig entity) {
        return this.repository.save(entity);
    }

    public boolean existsById(Long id) {
        return this.repository.existsById(id);
    }

    @Transactional()
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public Optional<Pig> findByIdAndStall(Long id, String nameStall) {
        return this.repository.findByIdAndStall(id, nameStall);
    }

    public Optional<Pig> findById(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Pig> findByIdWithStall(Long id) {
        return this.repository.findOneWithStallById(id);
    }

}
