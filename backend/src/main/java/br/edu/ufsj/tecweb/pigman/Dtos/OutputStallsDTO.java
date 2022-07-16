package br.edu.ufsj.tecweb.pigman.Dtos;

import br.edu.ufsj.tecweb.pigman.Domain.Stall;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OutputStallsDTO extends Stall {
    Integer totalPigs;
}
