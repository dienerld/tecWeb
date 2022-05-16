package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;
import java.util.List;

import br.edu.ufsj.tecweb.pigman.Domain.Pig;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StallDto {

    private Date lastRemoval;
    private String consumedFood;
    private Float weightAverage;
    private List<Pig> pigs;

}
