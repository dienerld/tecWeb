package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter()
@Getter()
@Entity
public class Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false, name = "weight_average")
    private Float weightAverage;

    @Column(nullable = false, name = "last_vermifuge")
    private Date lastVerfimuge;

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
}
