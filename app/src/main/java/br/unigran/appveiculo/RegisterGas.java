package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.unigran.domain.Car;
import br.unigran.domain.CarDAO;
import br.unigran.domain.Gas;
import br.unigran.domain.GasDAO;

public class RegisterGas extends AppCompatActivity {

    private EditText liters;
    private EditText value;
    private String carUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gas);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carUUID = (String) bundle.get("uuid");
        liters = findViewById(R.id.liters);
        value = findViewById(R.id.value);
    }

    /*** @param view*/
    public void saveGas(View view){
        Gas gas = new Gas();
        List<Car> cars = CarDAO.getData();
        for (Car car: cars) {
            if (car.getId().equals(carUUID)) {
                gas.setCar(car);
            }
        }
        gas.setLiters(Double.parseDouble(liters.getText().toString()));
        gas.setValue(Double.parseDouble(value.getText().toString()));
        GasDAO.save(gas);
        super.onBackPressed();
    }
}