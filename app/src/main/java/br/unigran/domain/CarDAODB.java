package br.unigran.domain;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

public class CarDAODB {

    private static SQLiteDatabase connect;

    public CarDAODB(SQLiteDatabase connect) {
        this.connect = connect;
    }

    public static void insertCar(Car car) {
        ContentValues values = new ContentValues();
        values.put("name", car.getName());
        values.put("plate", car.getPlate());
        values.put("color", car.getColor());
        connect.insert("CAR", null, values);
    }

    public static void updateCar(Car car) {
        ContentValues values = new ContentValues();
        values.put("name", car.getName());
        values.put("plate", car.getPlate());
        values.put("color", car.getColor());
        connect.update("CAR", values, "id=?", new String[]{car.getId().toString()});
    }

    public static void deleteCar(Integer id) {
        connect.delete("CAR", "id=?", new String[]{id.toString()});
    }

    public static List<Car> getCars() {
        List<Car> cars = new LinkedList<>();
        Cursor cursor;
        Car car;

        cursor = connect.rawQuery("SELECT * FROM CAR", null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            car = new Car();
            car.setId(cursor.getInt(cursor.getColumnIndex("id")));
            car.setName(cursor.getString(cursor.getColumnIndex("name")));
            car.setPlate(cursor.getString(cursor.getColumnIndex("plate")));
            car.setColor(cursor.getString(cursor.getColumnIndex("color")));
            cars.add(car);
            cursor.moveToNext();
        }

        return cars;
    }
}
