package br.unigran.domain;

public class Gas {
    private Integer id;
    private Float liters;
    private Float value;
    private Integer car;

    public float getLiters() {
        return liters;
    }
    public float getValue() {
        return value;
    }
    public Integer getCar() { return car; }

    public void setId(Integer id) { this.id = id; }
    public void setCar(Integer car) { this.car = car; }
    public void setLiters(Float liters) { this.liters = liters; }
    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Abastecimento de " + this.liters + " no valor de R$" + this.value;
    }
}
