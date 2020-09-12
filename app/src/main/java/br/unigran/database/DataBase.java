package br.unigran.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBase(@Nullable Context context) {
        super(context, "databaseAPP", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CAR (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                               "name varchar(100) NOT NULL," +
                               "plate varchar(7) NOT NULL," +
                               "color varchar(100)" +
                               ");");
        sqLiteDatabase.execSQL("CREATE TABLE GAS (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                               "liters REAL," +
                               "value REAL," +
                               "car INTEGER," +
                               "FOREIGN KEY(car) REFERENCES CAR(id)" +
                               ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
