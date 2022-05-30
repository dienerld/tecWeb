package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.List;

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

    @PostMapping()
    public ResponseEntity<Stall> postStalls(@RequestBody @Valid StallDTO entityBody) throws URISyntaxException {
        var newStall = new Stall();
        BeanUtils.copyProperties(entityBody, newStall);

        stallService.save(newStall);

        return ResponseEntity.created(new URI("stalls/" + newStall.getId())).body(newStall);
    }

    @PutMapping("/{id}")
    public String putStalls(@PathVariable("id") Long id) {

        return "Hello World";
    }

    @DeleteMapping("/{id}")
    public String deleteStalls(@PathVariable("id") Long id) {
        return "Hello World";
    }

}
