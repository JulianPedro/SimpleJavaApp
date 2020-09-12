package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import br.unigran.database.DataBase;
import br.unigran.domain.Car;
import br.unigran.domain.CarDAODB;

public class Actions extends AppCompatActivity {

    private DataBase dataBase;
    private CarDAODB cardaodb;
    private Integer carID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase = new DataBase(this);
        cardaodb = new CarDAODB(dataBase.getWritableDatabase());
        setContentView(R.layout.activity_actions);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carID = (Integer) bundle.get("id");
    }

    public void addGas(View view) {
        Intent intent = new Intent(Actions.this, RegisterGas.class);
        intent.putExtra("id", carID);
        startActivityForResult(intent,121);
    }

    public void listGas(View view) {
        Intent intent = new Intent(Actions.this, ListGas.class);
        intent.putExtra("id", carID);
        startActivityForResult(intent,121);
    }

    public void editCar(View view) {
        Intent intent = new Intent(Actions.this, RegisterCar.class);
        intent.putExtra("id", carID);
        startActivityForResult(intent,121);
    }

    public void removeCar(View View) {
        Intent intent = new Intent(Actions.this, MainActivity.class);
        List<Car> cars = CarDAODB.getCars();
        Car carForRemove = null;
        for(Car car: cars) {
            if(car.getId().equals(carID)) {
                carForRemove = car;
            }
        }
        CarDAODB.deleteCar(carForRemove.getId());
        startActivityForResult(intent, 121);
    }

}