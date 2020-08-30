package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import br.unigran.domain.Car;
import br.unigran.domain.CarDAO;

public class RegisterCar extends AppCompatActivity {

    private EditText name;
    private EditText color;
    private EditText plate;
    private String carUUID;
    private Car editCar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_register);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            carUUID = (String) bundle.get("uuid");
            List<Car> cars = CarDAO.getData();
            for (Car car: cars) {
                if(car.getId().equals(carUUID)) {
                    editCar = car;
                }
            }
        }
        name = findViewById(R.id.car_name);
        color = findViewById(R.id.car_color);
        plate = findViewById(R.id.car_plate);
        if (editCar != null) {
            name.setText(editCar.getName());
            color.setText(editCar.getColor());
            plate.setText(editCar.getPlate());
        }
    }

    /*** @param view*/
    public void saveCar(View view){
        if (editCar != null) {
           editCar.setName(name.getText().toString());
           editCar.setColor(color.getText().toString());
           editCar.setPlate(plate.getText().toString());
        } else {
            Car car = new Car();
            car.setName(name.getText().toString());
            car.setColor(color.getText().toString());
            car.setPlate(plate.getText().toString());
            CarDAO.save(car);
        }
        super.onBackPressed();
    }
}