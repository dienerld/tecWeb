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
    public ResponseEntity<Pig> create(@RequestBody PigDTO pigDto) throws URISyntaxException {

        var newPig = new Pig();
        BeanUtils.copyProperties(pigDto, newPig);

        var stall = new Stall();
        stall.setId(pigDto.getStallId());
        newPig.setStall(stall);
        newPig = this.pigService.save(newPig);

        return ResponseEntity.created(new URI("pigs/" + newPig.getId())).body(newPig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pig> update(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid PigDTO pigDto) throws Exception {

        var pig = this.pigService.findById(id).get();

        if (pig == null) {
            throw new Exception("Pig not found");
        }

        BeanUtils.copyProperties(pigDto, pig);

        return ResponseEntity.status(201).body(this.pigService.save(pig));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        this.pigService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
