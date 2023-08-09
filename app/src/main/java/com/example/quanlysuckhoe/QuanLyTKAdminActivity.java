package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuanLyTKAdminActivity extends AppCompatActivity {

    TextView tvTKBacSi, tvTKNguoiDung,tvThemBS;
    Button imgback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tkadmin);
        tvTKBacSi=(TextView) findViewById(R.id.tvTKBacSi);
        tvTKNguoiDung=(TextView) findViewById(R.id.tvTKNguoiDung);
        imgback=(Button) findViewById(R.id.imgBack3);
        tvThemBS=(TextView) findViewById(R.id.tvThemBacSi);

        tvTKBacSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyTKAdminActivity.this,QuanLyTKBacSiActivity.class);
                startActivity(intent);
            }
        });
        tvThemBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyTKAdminActivity.this,BacSiTuVanActivity.class);
                startActivity(intent);
            }
        });
        tvTKNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyTKAdminActivity.this,QuanLyTKNguoiDungActivity.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuanLyTKAdminActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
}