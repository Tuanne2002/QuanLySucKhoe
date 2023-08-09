package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DichVuChamSocBenhNhanActivity extends AppCompatActivity {
    Button btntrolai;
    TextView txtKhamVaDT,txtChuanDoan,txtXetNghiem,txtTiemPhong,txtTuVan,txtPhucHoi,txtChamSoc;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vu_cham_soc_benh_nhan);
        txtKhamVaDT=(TextView) findViewById(R.id.txtkham);
        txtChuanDoan=(TextView) findViewById(R.id.txtchuandoan);
        txtXetNghiem=(TextView) findViewById(R.id.txtxetnghiem);
        txtTuVan=(TextView) findViewById(R.id.txttuvan);
        txtTiemPhong=(TextView) findViewById(R.id.txttiemphong);
        txtPhucHoi=(TextView) findViewById(R.id.txtphuchoi);
        txtChamSoc=(TextView) findViewById(R.id.txtchamsoc);
        btntrolai = (Button) findViewById(R.id.imgBack);

        btntrolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DichVuChamSocBenhNhanActivity.this,TrangHomeActivity.class);
                startActivity(i);
            }
        });
        txtKhamVaDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,KhamVaDieuTriActivity.class);
                startActivity(intent);
            }
        });
        txtChuanDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,ChuanDoanHinhAnhActivity.class);
                startActivity(intent);
            }
        });
        txtTiemPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,TiemPhongActivity.class);
                startActivity(intent);
            }
        });
        txtXetNghiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,XetNghiemActivity.class);
                startActivity(intent);
            }
        });
        txtTuVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,TuVanSucKhoeActivity.class);
                startActivity(intent);
            }
        });
        txtPhucHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,PhucHoiChucNangActivity.class);
                startActivity(intent);
            }
        });
        txtChamSoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuChamSocBenhNhanActivity.this,ChamSocTamLyActivity.class);
                startActivity(intent);
            }
        });
    }
}