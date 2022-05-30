package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Mother;
import br.edu.ufsj.tecweb.pigman.Service.MotherService;
import br.edu.ufsj.tecweb.pigman.dtos.MotherDTO;

@RestController
@RequestMapping("/mother")
public class MotherResource {
    private final MotherService service;

    MotherResource(MotherService service) {
        this.service = service;

    }

    @GetMapping()
    public List<Mother> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Mother> findById(@PathVariable(value = "id") Long id) {
        return this.service.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Mother> create(@RequestBody MotherDTO entity) throws URISyntaxException {
        var newMother = new Mother();
        BeanUtils.copyProperties(entity, newMother);
        newMother = this.service.save(newMother);

        return ResponseEntity.created(new URI("mother/" + newMother.getId())).body(newMother);
    }
}
