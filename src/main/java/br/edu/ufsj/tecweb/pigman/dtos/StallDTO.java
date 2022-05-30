package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StallDTO {
    @NotBlank
    private String name;

    private Date lastRemoval;

}
