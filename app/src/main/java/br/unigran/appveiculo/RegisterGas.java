package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import br.unigran.database.DataBase;
import br.unigran.domain.Car;
import br.unigran.domain.CarDAODB;
import br.unigran.domain.Gas;
import br.unigran.domain.GasDAODB;

public class RegisterGas extends AppCompatActivity {

    private EditText liters;
    private EditText value;
    private Integer carID;
    private DataBase dataBase;
    private GasDAODB gasDAODB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gas);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carID = (Integer) bundle.get("id");
        liters = findViewById(R.id.liters);
        value = findViewById(R.id.value);
    }

    /*** @param view*/
    public void saveGas(View view){
        Gas gas = new Gas();
        List<Car> cars = CarDAODB.getCars();
        for (Car car: cars) {
            if (car.getId().equals(carID)) {
                gas.setCar(car.getId());
            }
        }
        gas.setLiters(Float.parseFloat(liters.getText().toString()));
        gas.setValue(Float.parseFloat(value.getText().toString()));
        gas.setCar(carID);
        dataBase = new DataBase(this);
        gasDAODB = new GasDAODB(dataBase.getWritableDatabase());
        gasDAODB.insertGAS(gas);
        super.onBackPressed();
    }
}