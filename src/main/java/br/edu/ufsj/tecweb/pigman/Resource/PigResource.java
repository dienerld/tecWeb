package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Repository.PigRepository;

@RestController
@RequestMapping("/pig")
public class PigResource {
    private final PigRepository pigRepository;

    PigResource(PigRepository repository) {
        this.pigRepository = repository;
    }

    @GetMapping("/")
    public List<Pig> listAll() {
        return this.pigRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Pig> create(@RequestBody Pig entity) throws URISyntaxException {
        Pig newPig = this.pigRepository.save(entity);
        return ResponseEntity.created(new URI("/api/pig" + newPig.getId())).body(newPig);
    }

}
