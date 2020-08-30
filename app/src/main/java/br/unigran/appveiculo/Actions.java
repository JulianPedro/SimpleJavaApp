package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import br.unigran.domain.Car;
import br.unigran.domain.CarDAO;

public class Actions extends AppCompatActivity {

    private String carUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carUUID = (String) bundle.get("uuid");
    }

    public void addGas(View view) {
        Intent intent = new Intent(Actions.this, RegisterGas.class);
        intent.putExtra("uuid", carUUID);
        startActivityForResult(intent,121);
    }

    public void listGas(View view) {
        Intent intent = new Intent(Actions.this, ListGas.class);
        intent.putExtra("uuid", carUUID);
        startActivityForResult(intent,121);
    }

    public void editCar(View view) {
        Intent intent = new Intent(Actions.this, RegisterCar.class);
        intent.putExtra("uuid", carUUID);
        startActivityForResult(intent,121);
    }

    public void removeCar(View View) {
        Intent intent = new Intent(Actions.this, MainActivity.class);
        List<Car> cars = CarDAO.getData();
        Car carForRemove = null;
        System.out.println(cars);
        for(Car car: cars) {
            if(car.getId().equals(carUUID)) {
                carForRemove = car;
            }
        }
        CarDAO.remove(carForRemove);
        startActivityForResult(intent, 121);
    }

}