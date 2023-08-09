package com.example.quanlysuckhoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseTKNguoiDung extends SQLiteOpenHelper {
    public DatabaseTKNguoiDung(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void INSERT_TKNguoiDung(String tenBacSi,String ngaySinh,String gioiTinh,int soDienThoai,String diaChi,String taiKhoan,String matKhau){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO TKCaNhan VALUES(null,?,?,?,?,?,?,?,?)";//? để phiên dịch riêng thú tự (0,1,2,3) bên dưới
        SQLiteStatement statement=database.compileStatement(sql);//đổ dữ liệu vào các dấu ?
        statement.clearBindings();//khi phân tích xong thì xóa

        statement.bindString(1,tenBacSi);//phiên dịch dữ liệu cho dấu ?
        statement.bindString(2,ngaySinh);
        statement.bindString(3,gioiTinh);
        statement.bindString(4, String.valueOf(soDienThoai));
        statement.bindString(5,diaChi);
        statement.bindString(6,taiKhoan);
        statement.bindString(7,matKhau);
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
