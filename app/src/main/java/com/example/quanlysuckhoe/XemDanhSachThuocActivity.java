package com.example.quanlysuckhoe;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class XemDanhSachThuocActivity extends AppCompatActivity {

    View imgThem;

    Button imgback4;
    ListView lvThuoc;
    ArrayList<Thuoc> thuocList;
    XemThuocAdapter xemThuocAdapter;
    public static DatabaseThuoc databaseThuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_danh_sach_thuoc);
        imgback4 = (Button) findViewById(R.id.imgBack4);
        lvThuoc=(ListView) findViewById(R.id.lvThuoc);
        thuocList=new ArrayList<>();
        xemThuocAdapter=new XemThuocAdapter(this,R.layout.xemthuoc,thuocList);
        lvThuoc.setAdapter(xemThuocAdapter);
        imgback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(XemDanhSachThuocActivity.this,TrangHomeActivity.class);
                startActivity(i);
            }
        });
        databaseThuoc=new DatabaseThuoc(this,"AppQuanLySucKhoe",null,1);
        databaseThuoc.QueryData("CREATE TABLE IF NOT EXISTS Thuoc(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TenBenhNhan VARCHAR(30)," +
                "TenThuoc VARCHAR(30)," +
                " SoLuong VARCHAR(30), " +
                "CongDung VARCHAR(30)," +
                "NgayBD VARCHAR(15), " +
                "NgayKT VARCHAR(15)" +
                ");");
        GetDataXemThuoc();
    }
    public void GetDataXemThuoc(){
        Cursor cursor= databaseThuoc.GetData("SELECT * FROM Thuoc");
        while (cursor.moveToNext()){
            thuocList.add(new Thuoc(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)

            ));
        }
        xemThuocAdapter.notifyDataSetChanged();
    }
}