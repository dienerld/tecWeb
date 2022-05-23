package br.edu.ufsj.tecweb.pigman.dtos;

import java.util.Date;

public class PigDto {

    private Date lastVerfimuge;
    private String sex;
    private Float weight;
    private Date entryDate;
    private Date birthDate;
    private Long stallId;

    public Date getLastVerfimuge() {
        return lastVerfimuge;
    }

    public void setLastVerfimuge(Date lastVerfimuge) {
        this.lastVerfimuge = lastVerfimuge;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getStallId() {
        return stallId;
    }

    public void setStallId(Long stallId) {
        this.stallId = stallId;
    }

}
