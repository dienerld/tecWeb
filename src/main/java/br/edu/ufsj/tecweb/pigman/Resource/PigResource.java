package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import br.edu.ufsj.tecweb.pigman.Service.PigService;
import br.edu.ufsj.tecweb.pigman.dtos.PigDTO;

@RestController
@RequestMapping("/pigs")
public class PigResource {
    private final PigService pigService;

    PigResource(PigService pigService) {
        this.pigService = pigService;
    }

    @GetMapping()
    public List<Pig> listAll() {
        return this.pigService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pig> findByIdWithStall(@PathVariable(value = "id") Long id) {
        return this.pigService.findByIdWithStall(id);
    }

    @PostMapping()
    public ResponseEntity<Pig> create(@RequestBody PigDTO entity) throws URISyntaxException {

        var newPig = new Pig();
        BeanUtils.copyProperties(entity, newPig);

        var stall = new Stall();
        stall.setId(entity.getStallId());
        newPig.setStall(stall);
        newPig = this.pigService.save(newPig);

        return ResponseEntity.created(new URI("pigs/" + newPig.getId())).body(newPig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pig> update(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid PigDTO entity) throws Exception {

        Optional<Pig> pigOptional = this.pigService.findById(id);

        if (!pigOptional.isPresent()) {
            throw new Exception("Pig not found");
        }

        var newPig = new Pig();
        BeanUtils.copyProperties(entity, newPig);
        newPig.setId(pigOptional.get().getId());

        return ResponseEntity.status(201).body(this.pigService.save(newPig));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        this.pigService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
