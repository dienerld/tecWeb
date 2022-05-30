package br.edu.ufsj.tecweb.pigman.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Birth;
import br.edu.ufsj.tecweb.pigman.Repository.BirthRepository;

@Service
public class BirthService {

    private final BirthRepository birthRepository;

    public BirthService(BirthRepository birthRepository) {
        this.birthRepository = birthRepository;
    }

    public List<Birth> findAll() {
        return this.birthRepository.findAll();
    }

    public Birth save(Birth birth) {
        return this.birthRepository.save(birth);
    }

    public Optional<Birth> findOne(Long id) {
        return this.birthRepository.findById(id);
    }

    public void delete(Long id) {
        this.birthRepository.deleteById(id);
        return;
    }

}
