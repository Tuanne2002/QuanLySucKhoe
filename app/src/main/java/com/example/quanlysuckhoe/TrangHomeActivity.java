package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TrangHomeActivity extends AppCompatActivity {



    Button dichvuchamsoc,hosobenhnhan, bacsituvan, donthuoc, trangchu,thoat;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_home);
        thoat = (Button) findViewById(R.id.imgthoat);
        dichvuchamsoc = (Button) findViewById(R.id.btndichvu);
        hosobenhnhan = (Button) findViewById(R.id.h_s_b_nh_nh);
        bacsituvan = (Button) findViewById(R.id.b_c_s_t_v_n);
        donthuoc = (Button) findViewById(R.id.n_thu_c);
        trangchu = (Button) findViewById(R.id.home) ;

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeActivity.this,DangNhapActivity.class);
                startActivity(i);
            }
        });

        dichvuchamsoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeActivity.this,DichVuChamSocBenhNhanActivity.class);
                startActivity(i);
            }
        });

        hosobenhnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeActivity.this,XemHoSoBenhActivity.class);
                startActivity(i);
            }
        });


        bacsituvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeActivity.this,XemDsBacSiActivity.class);
                startActivity(i);
            }
        });

        donthuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeActivity.this,XemDanhSachThuocActivity.class);
                startActivity(i);
            }
        });



        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Bạn Đang Ở Trang Chủ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}