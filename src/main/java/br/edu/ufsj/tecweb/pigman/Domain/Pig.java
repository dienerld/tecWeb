package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pig")
    @JsonIgnore
    private Slaugther slaugther;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "birth_id")
    private Birth birth;

}
