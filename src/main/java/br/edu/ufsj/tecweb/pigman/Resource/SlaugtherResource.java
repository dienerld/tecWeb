package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Domain.Slaugther;
import br.edu.ufsj.tecweb.pigman.Service.SlaugtherService;
import br.edu.ufsj.tecweb.pigman.dtos.SlaugtherDTO;

@RequestMapping("/slaugthers")
@RestController
public class SlaugtherResource {

    private final SlaugtherService slaugtherService;

    public SlaugtherResource(SlaugtherService slaugtherService) {
        this.slaugtherService = slaugtherService;
    }

    @GetMapping
    public String get() {
        return "SlaugtherResource";
    }

    @PostMapping
    public ResponseEntity<Slaugther> create(@RequestBody SlaugtherDTO entityDTO) throws URISyntaxException {
        var newSlaugther = new Slaugther();
        BeanUtils.copyProperties(entityDTO, newSlaugther);

        var slaugtherSaved = this.slaugtherService.save(newSlaugther);

        return ResponseEntity.created(new URI("/slaugthers/" + slaugtherSaved.getId())).body(slaugtherSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slaugther> update(@PathVariable(value = "id") Long id,
            @RequestBody SlaugtherDTO entityDTO) {
        var slaugther = new Slaugther();

        BeanUtils.copyProperties(entityDTO, slaugther);
        slaugther.setId(id);
        var pig = new Pig();
        pig.setId(entityDTO.getIdPig());
        slaugther.setPig(pig);

        return ResponseEntity.ok(slaugther);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Slaugther> delete(@PathVariable(value = "id") Long id) {
        this.slaugtherService.delete(id);

        return ResponseEntity.ok().build();
    }
}
