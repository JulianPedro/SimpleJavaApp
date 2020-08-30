package br.unigran.domain;

public class Gas {
    private double liters;
    private double value;
    private Car car;

    public double getLiters() {
        return liters;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Abastecimento de " + this.liters + " no valor de R$" + this.value;
    }
}
