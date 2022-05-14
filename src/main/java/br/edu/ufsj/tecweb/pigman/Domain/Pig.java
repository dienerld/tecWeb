package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private Float weight_average;

    @Column(nullable = false, name = "last_vermifuge")
    private Date lastVerfimuge;

    @Column(nullable = false, name = "entry_date")
    private Date entryDate;

    @Column(nullable = false, name = "birth_date")
    private Date birthDate;

}
