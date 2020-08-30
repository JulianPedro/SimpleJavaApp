package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.unigran.domain.Car;
import br.unigran.domain.CarDAO;
import br.unigran.domain.GasDAO;

public class ListGas extends AppCompatActivity {

    private ListView listGas;
    private String carUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gas);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carUUID = (String) bundle.get("uuid");
        listGas=findViewById(R.id.listGas);
        reloadList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reloadList();
    }

    public void reloadList(){
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, GasDAO.getData(carUUID));
        listGas.setAdapter(adapter);
    }
}