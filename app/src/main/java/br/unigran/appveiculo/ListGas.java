package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.unigran.database.DataBase;
import br.unigran.domain.CarDAODB;
import br.unigran.domain.GasDAODB;

public class ListGas extends AppCompatActivity {

    private ListView listGas;
    private Integer carID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gas);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        carID = (Integer) bundle.get("id");
        listGas=findViewById(R.id.listGas);
        reloadList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reloadList();
    }

    public void reloadList(){
        DataBase dataBase = new DataBase(this);
        GasDAODB dao = new GasDAODB(dataBase.getWritableDatabase());
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, dao.getGas(carID));
        listGas.setAdapter(adapter);
    }
}