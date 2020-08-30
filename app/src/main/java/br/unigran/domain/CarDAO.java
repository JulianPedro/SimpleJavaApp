package br.unigran.domain;

import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static List<Car> data = new ArrayList<>();
    private CarDAO(){}
    public static  void save(Car car){
        data.add(car);
    }
    public static  void remove(Car car){
        data.remove(car);
    }
    public static List getData(){
        return data;
    }
}
