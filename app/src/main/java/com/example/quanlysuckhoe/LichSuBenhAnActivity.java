package com.example.quanlysuckhoe;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LichSuBenhAnActivity extends AppCompatActivity {
    Button imgThem;
    Button back;
    //ImageView imgThem,imgBack;
    ListView lvBenhAn;
    ArrayList<LichSuBenh> lichSuBenhs;
    LichSuBenhAdapter lichSuBenhAdapter;
    public static DatabaseLichSuBenh databaseLichSuBenh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_benh_an);

        imgThem = (Button) findViewById(R.id.imgThemBenh);
        back = (Button) findViewById(R.id.arrow_back_);
        lvBenhAn = (ListView) findViewById(R.id.lvBenhAn);


        lichSuBenhs = new ArrayList<>();
        lichSuBenhAdapter = new LichSuBenhAdapter(this,R.layout.lich_su_kham,lichSuBenhs);
        lvBenhAn.setAdapter(lichSuBenhAdapter);
        databaseLichSuBenh=new DatabaseLichSuBenh(this,"AppQuanLySucKhoe",null,1);
        databaseLichSuBenh.QueryData("CREATE TABLE IF NOT EXISTS LichSuBenh(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +

                " TenBenh VARCHAR(30), " +
                "LyDoBenh VARCHAR(30)," +
                "Time VARCHAR(100)" +
                ");");
        //get data
        GetDaTaBenhAn();
        imgThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LichSuBenhAnActivity.this,ThemLichSuKhamActivity.class);
                startActivity(intent);
            }
        });
    }
    public void GetDaTaBenhAn(){
        Cursor cursor= databaseLichSuBenh.GetData("SELECT * FROM LichSuBenh");
        while (cursor.moveToNext()){
            lichSuBenhs.add(new LichSuBenh(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)

            ));
        }
        lichSuBenhAdapter.notifyDataSetChanged();
    }
}