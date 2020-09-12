package br.unigran.domain;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

public class GasDAODB {

    private static SQLiteDatabase connect;

    public GasDAODB(SQLiteDatabase connect) {
        this.connect = connect;
    }

    public static void insertGAS(Gas gas) {
        ContentValues values = new ContentValues();
        values.put("liters", gas.getLiters());
        values.put("value", gas.getValue());
        values.put("car", gas.getCar());
        connect.insert("GAS", null, values);
    }

    public static List<Gas> getGas(Integer id) {
        List<Gas> gases = new LinkedList<>();
        Cursor cursor;
        Gas gas;

        String[] params = new String[]{ id.toString() };
        cursor = connect.rawQuery("SELECT * FROM GAS WHERE CAR = ?", params);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++)  {
            gas = new Gas();
            gas.setId(cursor.getInt(cursor.getColumnIndex("id")));
            gas.setLiters(cursor.getFloat(cursor.getColumnIndex("liters")));
            gas.setValue(cursor.getFloat(cursor.getColumnIndex("value")));
            gas.setCar(cursor.getInt(cursor.getColumnIndex("car")));
            gases.add(gas);
            cursor.moveToNext();
        }
        return gases;
    }
}
