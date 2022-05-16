package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "food")
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = false, name = "price")
    private Float price;

    @Column(nullable = false, name = "quantity")
    private Float quantity;

    @Column(nullable = false, name = "date")
    private Date date;

    @CreationTimestamp()
    @Column(nullable = false, name = "created_at")
    private Date created_at;

    @UpdateTimestamp()
    @Column(nullable = false, name = "updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "stall_id")
    private Stall stall;
}
