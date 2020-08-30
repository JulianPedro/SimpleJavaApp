package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.unigran.domain.Car;
import br.unigran.domain.CarDAO;

public class MainActivity extends AppCompatActivity {

    private ListView listCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCar=findViewById(R.id.listCar);
        reloadList();
        listCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Actions.class);
                Car car = (Car) CarDAO.getData().get(position);
                intent.putExtra("uuid", car.getId());
                startActivityForResult(intent, 121);
            }
        });
    }
    /**
     * @param view
     */
    public void newCar(View view){
        Intent intent = new Intent(MainActivity.this, RegisterCar.class);
        startActivityForResult(intent,121);
    }
    public void editCar(){
        Intent intent = new Intent(MainActivity.this, RegisterCar.class);
        intent.putExtra("car", (Parcelable) null);
        startActivityForResult(intent, RESULT_OK);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reloadList();
    }
    public void reloadList(){
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, CarDAO.getData());
        listCar.setAdapter(adapter);
    }

}