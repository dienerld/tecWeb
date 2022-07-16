package br.edu.ufsj.tecweb.pigman.Dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputPigDto {
    private String sex;
    private String nameStall;
    private Float weight;
    private Date lastVermifuge;
    private Date entryDate;
    private Date birthDate;

}
