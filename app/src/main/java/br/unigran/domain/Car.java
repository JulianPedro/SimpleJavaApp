package br.unigran.domain;

import java.util.List;
import java.util.UUID;

public class Car {
    private String id;
    private String name;
    private String plate;
    private String color;
    private List<Gas> gases;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Gas> getGases() {
        return gases;
    }

    public void setGases(List<Gas> gases) {
        this.gases = gases;
    }

    public Car() { this.id = UUID.randomUUID().toString(); }

    public void setName(String name) {this.name = name;}

    public String getPlate() {return plate;}

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name;
    }
}
