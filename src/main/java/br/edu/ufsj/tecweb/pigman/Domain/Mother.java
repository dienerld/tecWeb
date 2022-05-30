package br.edu.ufsj.tecweb.pigman.Domain;

import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "mother")
@Getter
@Setter
public class Mother extends Pig {
    private final List<Pig> pigs;
}
