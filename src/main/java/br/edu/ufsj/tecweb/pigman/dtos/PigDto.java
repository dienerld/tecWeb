package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class PigDto {

    private String sex;
    private Float weightAverage;
    private Date lastVerfimuge;
    private Date entryDate;
    private Date birthDate;

}
