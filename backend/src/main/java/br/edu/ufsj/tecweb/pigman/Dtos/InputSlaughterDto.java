package br.edu.ufsj.tecweb.pigman.Dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputSlaughterDto {
    Long pigId;
    Date date;
    Float netWeight;
    Float sellPrice;
    Long stallId;
}
