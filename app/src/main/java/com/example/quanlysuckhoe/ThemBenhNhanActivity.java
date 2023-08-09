package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemBenhNhanActivity extends AppCompatActivity {

    Button addBN, huy,xemlichsu ;
    EditText edtMa, edtTen, edtGT, edtDiachi, edtSDT,edtbenhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_benh_nhan);



        addBN = (Button) findViewById(R.id.btnThem);
        huy = (Button) findViewById(R.id.btnHuy);
        edtMa =(EditText) findViewById(R.id.edtMaBenhNhan);
        edtTen = (EditText) findViewById(R.id.edtTenBenhNhan);
        edtGT = (EditText) findViewById(R.id.edtGioiTinh);
        edtDiachi = (EditText) findViewById(R.id.edtDiaChi);
        edtSDT = (EditText) findViewById(R.id.edtPhone);
        edtbenhan = (EditText) findViewById(R.id.edtBenhAn);

        addBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maBN = edtMa.getText().toString();
                String tenBN = edtTen.getText().toString();
                String gioiTinh = edtGT.getText().toString();
                String diaChi = edtDiachi.getText().toString();
                String phone = edtSDT.getText().toString();
                String benhAn = edtbenhan.getText().toString();

                if (maBN.equals("") || tenBN.equals("") || gioiTinh.equals("") || diaChi.equals("") || phone.equals("") || benhAn.equals("")) {
                    if (maBN.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập mã bệnh nhân", Toast.LENGTH_SHORT).show();
                    } else if (tenBN.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show();
                    } else if (gioiTinh.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập giới tính", Toast.LENGTH_SHORT).show();
                    } else if (diaChi.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập địa chỉ", Toast.LENGTH_SHORT).show();
                    } else if (phone.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    } else if (benhAn.equals("")) {
                        Toast.makeText(ThemBenhNhanActivity.this, "Vui lòng nhập bệnh án", Toast.LENGTH_SHORT).show();
                    }
                    } else {
                        HoSoBenhNhanActivity.databaseBenhNhan.INSERT_BenhNhan(
                                edtMa.getText().toString().trim(),
                                edtTen.getText().toString().trim(),
                                edtGT.getText().toString().trim(),
                                edtDiachi.getText().toString().trim(),
                                Integer.parseInt(edtSDT.getText().toString().trim()),
                                edtbenhan.getText().toString().trim()
                        );
                        Toast.makeText(ThemBenhNhanActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ThemBenhNhanActivity.this,HoSoBenhNhanActivity.class);
                        startActivity(i);

                    }
                }

        });



        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemBenhNhanActivity.this,HoSoBenhNhanActivity.class);
                startActivity(i);
            }
        });


    }
}