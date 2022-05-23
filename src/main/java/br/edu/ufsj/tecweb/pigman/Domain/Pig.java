package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "pig")
public class Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = true, name = "last_vermifuge")
    private Date lastVerfimuge;

    @Column(nullable = false, name = "weight")
    private Float weight;

    @Column(nullable = false, name = "entry_date")
    private Date entryDate;

    @Column(nullable = false, name = "birth_date")
    private Date birthDate;

    @CreationTimestamp()
    @Column(nullable = false, name = "created_at")
    private Date created_at;

    @UpdateTimestamp()
    @Column(nullable = false, name = "updated_at")
    private Date updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "stall_id")
    private Stall stall;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getLastVerfimuge() {
        return lastVerfimuge;
    }

    public void setLastVerfimuge(Date lastVerfimuge) {
        this.lastVerfimuge = lastVerfimuge;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

}
