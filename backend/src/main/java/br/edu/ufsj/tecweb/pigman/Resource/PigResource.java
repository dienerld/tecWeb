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
import br.edu.ufsj.tecweb.pigman.Service.StallService;
import br.edu.ufsj.tecweb.pigman.dtos.PigDTO;

// @CrossOrigin(origins = "*")
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

    /**
     * > This function returns a pig with its stall
     *
     * @param id the id of the pig
     * @return A pig with a stall.
     */
    @GetMapping("/{id}")
    public Optional<Pig> findByIdWithStall(@PathVariable(value = "id") Long id) {
        return this.pigService.findByIdWithStall(id);
    }

    /**
     * > We create a new pig, copy the properties from the DTO to the new pig, set
     * the stall id, save
     * the new pig, and return
     *
     * @param pigDto The object that will be used to create the new pig.
     * @return A ResponseEntity with the created URI and the newPig object.
     */
    @PostMapping()
    public ResponseEntity<Pig> create(@RequestBody PigDTO pigDto) throws URISyntaxException {
        var newPig = new Pig();
        BeanUtils.copyProperties(pigDto, newPig);

        var stall = this.stallService.findById(pigDto.getStallId()).get();
        newPig.setStall(stall);
        newPig = this.pigService.save(newPig);
        newPig = this.findByIdWithStall(newPig.getId()).get();
        if (newPig == null) {
            return ResponseEntity.badRequest().build();
        }

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
