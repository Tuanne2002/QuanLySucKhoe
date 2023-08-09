package com.example.quanlysuckhoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseTKBacSi extends SQLiteOpenHelper {
    public DatabaseTKBacSi(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void INSERT_TKBacSi(String tenBacSi,int soDienThoai,String diaChi,String chuyenKhoa,String kinhNghiem,String taiKhoan,String matKhau,String vaiTro){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO TKBacSi VALUES(null,?,?,?,?,?,?,?,?)";//? để phiên dịch riêng thú tự (0,1,2,3) bên dưới
        SQLiteStatement statement=database.compileStatement(sql);//đổ dữ liệu vào các dấu ?
        statement.clearBindings();//khi phân tích xong thì xóa
        statement.bindString(1,tenBacSi);//phiên dịch dữ liệu cho dấu ?
        statement.bindString(2, String.valueOf(soDienThoai));
        statement.bindString(3,diaChi);
        statement.bindString(4,chuyenKhoa);
        statement.bindString(5,kinhNghiem);
        statement.bindString(6,taiKhoan);
        statement.bindString(7,matKhau);
        statement.bindString(8,vaiTro);
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
