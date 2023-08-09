package com.example.quanlysuckhoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseBenhNhan extends SQLiteOpenHelper {

    public DatabaseBenhNhan(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    public void INSERT_BenhNhan(String maBenhNhan ,String tenBenhNhan,String gioiTinh,String diaChi,int phone,String benhAn){
        SQLiteDatabase databaseBN=getWritableDatabase();
        String sql="INSERT INTO BenhNhan VALUES(null,?,?,?,?,?,?)";//? để phiên dịch riêng thú tự (0,1,2,3) bên dưới
        SQLiteStatement statement=databaseBN.compileStatement(sql);//đổ dữ liệu vào các dấu ?
        statement.clearBindings();//khi phân tích xong thì xóa
        statement.bindString(1, maBenhNhan);
        statement.bindString(2,tenBenhNhan);//phiên dịch dữ liệu cho dấu ?
        statement.bindString(3,gioiTinh);
        statement.bindString(4,diaChi);
        statement.bindString(5, String.valueOf(phone));
        statement.bindString(6,benhAn);
        statement.executeInsert();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
