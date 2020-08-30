package br.unigran.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GasDAO {
    private static List<Gas> data = new ArrayList<>();
    private GasDAO(){}
    public static  void save(Gas gas){
        data.add(gas);
    }

    public static List getData(final String uuid){
        List<Gas> gasesFiltered = new ArrayList<>();
        for (Gas gas: data) {
            if (gas.getCar().getId().equals(uuid)) {
                gasesFiltered.add(gas);
            }
        }
        return gasesFiltered;
    }
}