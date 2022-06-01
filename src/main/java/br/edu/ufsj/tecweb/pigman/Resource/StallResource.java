package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import br.edu.ufsj.tecweb.pigman.Service.StallService;
import br.edu.ufsj.tecweb.pigman.dtos.StallDTO;

@RestController
@RequestMapping("/stalls")
public class StallResource {

    private StallService stallService;

    StallResource(StallService service) {
        this.stallService = service;
    }

    @GetMapping()
    public List<Stall> getAll() {
        return this.stallService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Stall>> getById(@PathVariable("id") Long id) {
        try {
            var stall = this.stallService.findById(id);
            return ResponseEntity.ok(stall);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Stall> create(@RequestBody @Valid StallDTO stallDto) throws URISyntaxException {
        var newStall = new Stall();
        BeanUtils.copyProperties(stallDto, newStall);

        stallService.save(newStall);

        return ResponseEntity.created(new URI("stalls/" + newStall.getId())).body(newStall);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stall> update(@PathVariable("id") Long id,
            @RequestBody StallDTO stallDto) throws Exception {
        var stall = this.stallService.findById(id).get();

        if (stall == null) {
            throw new Exception("Pig not found");
        }

        BeanUtils.copyProperties(stallDto, stall);
        this.stallService.save(stall);

        return ResponseEntity.ok(stall);
    }

    @DeleteMapping("/{id}")
    public String deleteStalls(@PathVariable("id") Long id) {
        return "Hello World";
    }

}
