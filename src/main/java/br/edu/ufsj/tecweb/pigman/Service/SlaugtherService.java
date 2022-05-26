package br.edu.ufsj.tecweb.pigman.Service;

import org.springframework.stereotype.Service;

import br.edu.ufsj.tecweb.pigman.Domain.Slaugther;
import br.edu.ufsj.tecweb.pigman.Repository.SlaugtherRepository;

@Service
public class SlaugtherService {
    private final SlaugtherRepository slaugtherRepository;

    public SlaugtherService(SlaugtherRepository slaugtherRepository) {
        this.slaugtherRepository = slaugtherRepository;
    }

    public Slaugther save(Slaugther slaugther) {
        return this.slaugtherRepository.save(slaugther);
    }

    public void delete(Long id) {
        this.slaugtherRepository.deleteById(id);
        return;
    }
}
