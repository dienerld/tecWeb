package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "slaugther")
public class Slaugther {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column(name = "net_weight")
    private Float netWeight;

    @Column(name = "sell_price")
    private Float sellPrice;
    @OneToOne()
    @JoinColumn(name = "pig_fk_id", referencedColumnName = "id")
    private Pig pig;

}
