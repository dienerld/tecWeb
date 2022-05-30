package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {
    private String type;
    private Float price;
    private Float quantity;
    private Date date;
}
