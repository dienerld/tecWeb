package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "stall")
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "last_removal")
    private Date lastRemoval;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "weight_average")
    private Float weightAverage;

    @CreationTimestamp()
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp()
    @Column(name = "updated_at")
    private Date updated_at;

    @OneToMany(mappedBy = "stall")
    private List<Pig> pigs;

}
