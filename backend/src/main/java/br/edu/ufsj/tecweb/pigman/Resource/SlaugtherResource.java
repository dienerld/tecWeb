package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Slaugther>> findAll() {
        var list = this.slaugtherService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Slaugther> create(@RequestBody SlaugtherDTO slaugtherDto) throws URISyntaxException {
        var newSlaugther = new Slaugther();
        BeanUtils.copyProperties(slaugtherDto, newSlaugther);

        var slaugtherSaved = this.slaugtherService.save(newSlaugther);

        return ResponseEntity.created(new URI("/slaugthers/" + slaugtherSaved.getId())).body(slaugtherSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slaugther> update(@PathVariable(value = "id") Long id,
            @RequestBody SlaugtherDTO slaugtherDto) throws Exception {

        var slaugther = this.slaugtherService.findById(id).get();
        if (slaugther == null) {
            throw new Exception("slaugther not found");
        }
        BeanUtils.copyProperties(slaugtherDto, slaugther);
        this.slaugtherService.save(slaugther);

        return ResponseEntity.ok(slaugther);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Slaugther> delete(@PathVariable(value = "id") Long id) {
        this.slaugtherService.delete(id);

        return ResponseEntity.ok().build();
    }
}
