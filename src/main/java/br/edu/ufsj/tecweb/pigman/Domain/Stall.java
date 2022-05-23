package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "stall")
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "last_removal")
    private Date lastRemoval;

    @Column(name = "name")
    private String name;

    @Column(name = "weight_average")
    private Float weightAverage;

    @CreationTimestamp()
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp()
    @Column(name = "updated_at")
    private Date updated_at;

    @OneToMany(mappedBy = "stall", fetch = FetchType.LAZY)
    private List<Pig> pigs;

    @OneToMany(mappedBy = "stall")
    private List<Food> foods;

    // getters and setters
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Date getLastRemoval() {
        return lastRemoval;
    }

    public void setLastRemoval(Date lastRemoval) {
        this.lastRemoval = lastRemoval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeightAverage() {
        return weightAverage;
    }

    public void setWeightAverage(Float weightAverage) {
        this.weightAverage = weightAverage;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public List<Pig> getPigs() {
        return pigs;
    }

    public void setPigs(List<Pig> pigs) {
        this.pigs = pigs;
    }

    @JsonIgnore
    public List<Food> getFoods() {
        return foods;
    }

    @JsonIgnore
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
