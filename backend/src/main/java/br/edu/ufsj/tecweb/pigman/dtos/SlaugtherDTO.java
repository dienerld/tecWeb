package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class SlaugtherDTO {
    @NotBlank
    private Long idPig;
    private Date date;
    private Float netWeight;
    private Float sellPrice;
}
