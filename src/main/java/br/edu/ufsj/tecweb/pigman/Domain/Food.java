package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = false, name = "price")
    private Float price;

    @Column(nullable = false, name = "quantity")
    private Float quantity;

    @Column(nullable = true, name = "date")
    private Date date;

    @CreationTimestamp()
    @Column(nullable = false, name = "created_at")
    private Date created_at;

    @UpdateTimestamp()
    @Column(nullable = false, name = "updated_at")
    private Date updated_at;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stall_id")
    private Stall stall;

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

}
