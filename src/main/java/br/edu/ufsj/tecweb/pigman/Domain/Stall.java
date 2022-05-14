package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "stall")
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false, name = "last_removal")
    private Date lastRemoval;

    @Column(nullable = false, name = "consumed_food")
    private Food consumedFood;

    @Column(nullable = false, name = "weight_average")
    private Float weightAverage;

    @OneToMany(mappedBy = "stall")
    private List<Pig> pigs;
}
