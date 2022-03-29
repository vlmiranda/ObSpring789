package com.OB_Spring_789_new.ObSpring789.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    // 1. Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String manufacturer;
    private Integer ram;
    private Double price;

    // 2. Constructores

    public Laptop(){}

    public Laptop(Long id, String manufacturer, Integer ram, Double price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.ram = ram;
        this.price = price;
    }

    // 3. Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
