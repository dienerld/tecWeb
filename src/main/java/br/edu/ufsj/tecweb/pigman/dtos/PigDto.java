package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class PigDto {

    @NotBlank
    private String sex;

    @NotBlank
    private Float weightAverage;

    @NotBlank
    private Date lastVerfimuge;

    @NotBlank
    private Date entryDate;

    @NotBlank
    private Date birthDate;

}
