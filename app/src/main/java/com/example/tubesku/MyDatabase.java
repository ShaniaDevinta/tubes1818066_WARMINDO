package com.example.tubesku;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_tubes";
    private static final String tb_order = "tb_order";
    private static final String tb_order_id = "id";
    private static final String tb_nama = "nama";
    private static final String tb_pesan = "pesan";
    private static final String tb_level = "level";
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE " +
            tb_order + "("
            + tb_order_id + " INTEGER PRIMARY KEY ,"
            + tb_nama + " TEXT,"
            + tb_pesan + " TEXT,"
            + tb_level + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateOrder (Order mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_order_id, mdNotif.get_id());
        values.put(tb_nama, mdNotif.get_nama());
        values.put(tb_pesan, mdNotif.get_pesan());
        values.put(tb_level, mdNotif.get_level());
        db.insert(tb_order, null, values);
        db.close();
    }

    public List<Order> ReadOrder() {
        List<Order> judulModelList = new ArrayList<Order>();
        String selectQuery = "SELECT * FROM " + tb_order;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Order mdKontak = new Order();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_pesan(cursor.getString(2));
                mdKontak.set_level(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateOrder (Order mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_nama, mdNotif.get_nama());
        values.put(tb_pesan, mdNotif.get_pesan());
        values.put(tb_level, mdNotif.get_level());
        return db.update(tb_order, values, tb_order_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteOrder (Order mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_order, tb_order_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
