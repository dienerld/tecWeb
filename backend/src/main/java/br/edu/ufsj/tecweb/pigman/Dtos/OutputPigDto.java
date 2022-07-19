package br.edu.ufsj.tecweb.pigman.Dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OutputPigDto {
    private Long id;
    private Date entryDate;
    private String sex;
    private Date lastVerfimuge;
    private Float weight;
    private String stallName;
    private Long stallId;
}
