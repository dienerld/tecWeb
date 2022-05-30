package br.edu.ufsj.tecweb.pigman.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufsj.tecweb.pigman.Domain.Birth;
import br.edu.ufsj.tecweb.pigman.Service.BirthService;
import br.edu.ufsj.tecweb.pigman.dtos.BirthDTO;

@RestController
@RequestMapping("/births")
public class BirthResource {

    private final BirthService birthService;

    public BirthResource(BirthService birthService) {
        this.birthService = birthService;
    }

    @GetMapping()
    public List<Birth> findAll() {
        return this.birthService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Birth>> findOne(@PathVariable(value = "id") Long id) {
        try {
            var birth = this.birthService.findOne(id);
            return ResponseEntity.ok(birth);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Birth> save(@RequestBody() BirthDTO entityDTO) throws URISyntaxException {
        var newBirth = new Birth();
        BeanUtils.copyProperties(entityDTO, newBirth);

        var birth = this.birthService.save(newBirth);

        return ResponseEntity.created(new URI("/births/" + birth.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Birth> delete(@PathVariable(value = "id") Long id) {
        try {
            this.birthService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
