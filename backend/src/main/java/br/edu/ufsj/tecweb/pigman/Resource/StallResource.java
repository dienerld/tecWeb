package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import br.edu.ufsj.tecweb.pigman.Dtos.OutputStallsDTO;
import br.edu.ufsj.tecweb.pigman.Service.StallService;

@RestController
@RequestMapping("/stalls")
public class StallResource {

    private StallService stallService;

    StallResource(StallService service) {
        this.stallService = service;
    }

    /**
     * It returns a list of all the stalls in the database.
     *
     * @return A list of OutputStallsDTO objects.
     */
    @JsonIgnore
    @GetMapping()
    public List<OutputStallsDTO> getAll() {
        var stalls = this.stallService.findAll();
        List<OutputStallsDTO> outputStalls = new ArrayList<OutputStallsDTO>();

        for (Stall stall : stalls) {
            OutputStallsDTO outputStall = new OutputStallsDTO();
            BeanUtils.copyProperties(stall, outputStall);
            outputStall.setTotalPigs(stall.getPigs().size());
            stall.setPigs(new ArrayList<Pig>());
            outputStalls.add(outputStall);

        }

        return outputStalls;
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
    public ResponseEntity<Stall> create(@RequestBody Stall stallDto) throws URISyntaxException {
        var newStall = new Stall();
        BeanUtils.copyProperties(stallDto, newStall);

        stallService.save(newStall);

        return ResponseEntity.created(new URI("stalls/" + newStall.getId())).body(newStall);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stall> update(@PathVariable("id") Long id,
            @RequestBody Stall stallDto) throws Exception {
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
