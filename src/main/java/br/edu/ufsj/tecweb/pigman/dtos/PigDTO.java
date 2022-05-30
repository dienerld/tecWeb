package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PigDTO {

    private Date lastVerfimuge;
    private String sex;
    private Float weight;
    private Date entryDate;
    private Date birthDate;
    private Long stallId;

}
