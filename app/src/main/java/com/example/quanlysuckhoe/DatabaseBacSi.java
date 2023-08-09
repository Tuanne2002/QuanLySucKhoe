package com.example.quanlysuckhoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseBacSi extends SQLiteOpenHelper {
    public DatabaseBacSi(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void INSERT_BacSi(String maBacSi,String tenBacSi,String chuyenKhoa,int soDienThoai,String kinhNghiem){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO BacSi VALUES(null,?,?,?,?,?)";//? để phiên dịch riêng thú tự (0,1,2,3) bên dưới
        SQLiteStatement statement=database.compileStatement(sql);//đổ dữ liệu vào các dấu ?
        statement.clearBindings();//khi phân tích xong thì xóa
        statement.bindString(1,maBacSi);
        statement.bindString(2,tenBacSi);//phiên dịch dữ liệu cho dấu ?
        statement.bindString(3,chuyenKhoa);
        statement.bindString(4, String.valueOf(soDienThoai));
        statement.bindString(5,kinhNghiem);
        statement.executeInsert();

    }
    public Cursor GetData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
