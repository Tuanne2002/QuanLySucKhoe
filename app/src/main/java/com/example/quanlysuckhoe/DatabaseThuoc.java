package com.example.quanlysuckhoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseThuoc extends SQLiteOpenHelper {
    public DatabaseThuoc(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sqlThuoc){
        SQLiteDatabase databaseThuoc = getWritableDatabase();
        databaseThuoc.execSQL(sqlThuoc);
    }
    public Cursor GetData(String sqlThuoc){
        SQLiteDatabase databaseThuoc=getReadableDatabase();
        return databaseThuoc.rawQuery(sqlThuoc,null);
    }
    public void INSERT_Thuoc(String tenBenhNhan,String tenThuoc,String soLuong,String congDung,String ngayBD,String ngayKT){
        SQLiteDatabase databaseThuoc=getWritableDatabase();
        String sql="INSERT INTO Thuoc VALUES(null,?,?,?,?,?,?)";//? để phiên dịch riêng thú tự (0,1,2,3) bên dưới
        SQLiteStatement statement=databaseThuoc.compileStatement(sql);//đổ dữ liệu vào các dấu ?
        statement.clearBindings();//khi phân tích xong thì xóa
        statement.bindString(1,tenBenhNhan);
        statement.bindString(2,tenThuoc);
        statement.bindString(3,soLuong);//phiên dịch dữ liệu cho dấu ?
        statement.bindString(4,congDung);
        statement.bindString(5,ngayBD);
        statement.bindString(6,ngayKT);
        statement.executeInsert();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
