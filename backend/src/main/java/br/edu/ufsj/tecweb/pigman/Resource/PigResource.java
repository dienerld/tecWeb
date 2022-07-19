package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import br.edu.ufsj.tecweb.pigman.Dtos.InputPigDto;
import br.edu.ufsj.tecweb.pigman.Dtos.OutputPigDto;
import br.edu.ufsj.tecweb.pigman.Service.PigService;
import br.edu.ufsj.tecweb.pigman.Service.StallService;

@RestController
@RequestMapping("/pigs")
public class PigResource {
    private final PigService pigService;
    private final StallService stallService;

    PigResource(PigService pigService, StallService stallService) {
        this.pigService = pigService;
        this.stallService = stallService;
    }

    @GetMapping()
    public List<Pig> listAll() {
        System.out.println("sadas1s");
        return this.pigService.findAll();
    }

    @GetMapping("/{id}")
    public OutputPigDto findByIdWithStall(@PathVariable(value = "id") Long id) {
        var pig = this.pigService.findById(id).get();
        var outputPig = new OutputPigDto();
        BeanUtils.copyProperties(pig, outputPig);
        outputPig.setStallId(pig.getStall().getId());
        outputPig.setStallName(pig.getStall().getName());

        return outputPig;
    }

    @GetMapping("/stall/{id}")
    public List<Pig> findPigsByStall(@PathVariable(value = "id") Long id) {
        var stall = new Stall();
        stall.setId(id);
        return this.pigService.findPigsByStall(stall);
    }

    @PostMapping()
    public ResponseEntity<Pig> create(@RequestBody InputPigDto pigDto) throws URISyntaxException {
        System.out.println(pigDto.getEntryDate());
        var stall = this.stallService.findByName(pigDto.getStallName());
        if (!stall.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        var pig = new Pig();
        BeanUtils.copyProperties(pigDto, pig);
        pig.setStall(stall.get());

        var newPig = this.pigService.save(pig);
        return ResponseEntity.created(new URI("pigs/" + newPig.getId())).body(newPig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pig> update(
            @PathVariable(value = "id") Long id,
            @RequestBody Pig pigDto) throws Exception {

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
