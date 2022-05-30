package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "mother")
@Getter
@Setter
public class Mother extends Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private Date cobertura;

    @OneToMany(mappedBy = "mother")
    @JsonIgnore
    private List<Pig> pigs;
}
