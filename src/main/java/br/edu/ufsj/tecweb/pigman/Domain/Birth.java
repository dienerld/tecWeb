package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "birth")
public class Birth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "birth", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pig> pigs;
}
