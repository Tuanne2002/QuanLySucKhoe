package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangHomeBacSiActivity extends AppCompatActivity {
    Button hoso, benhnhan,donthuoc,imgback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_home_bac_si);
        donthuoc = (Button) findViewById(R.id.n_thu_c);
        hoso = (Button) findViewById(R.id.h_s_b_nh_nh);
        benhnhan = (Button) findViewById(R.id.n_thu_c);
        imgback=(Button) findViewById(R.id.imgBack3);

        hoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeBacSiActivity.this,HoSoBenhNhanActivity.class);
                startActivity(i);
            }
        });
        donthuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangHomeBacSiActivity.this,DanhSachThuocActivity.class);
                startActivity(i);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TrangHomeBacSiActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
}