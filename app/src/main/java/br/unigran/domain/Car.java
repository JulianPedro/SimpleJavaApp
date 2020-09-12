package br.unigran.domain;

import java.util.List;
import java.util.UUID;

public class Car {
    private Integer id;
    private String name;
    private String plate;
    private String color;

    public Integer getId() { return id; }

    public String getName() {
        return name;
    }

    public String getPlate() {return plate;}

    public String getColor() {
        return color;
    }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) {this.name = name;}

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

     @Override
    public String toString() {
        return name;
    }
}
