package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemTKNguoiDungActivity extends AppCompatActivity {

    Button btnCapNhat, huy;
    EditText edtTen,edtNgaySinh,edtGioiTinh, edtSDT, edtDiachi,edtTK,edtMK;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tknguoi_dung);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        huy = (Button) findViewById(R.id.btnHuy);
        edtTen = (EditText) findViewById(R.id.edtTenBacSi);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        edtDiachi = (EditText) findViewById(R.id.edtDiaChi);
        edtGioiTinh = (EditText) findViewById(R.id.edtGioiTinh);
        edtNgaySinh = (EditText) findViewById(R.id.edtNgaySinh);
        edtTK = (EditText) findViewById(R.id.edtTenTK);
        edtMK = (EditText) findViewById(R.id.edtMatKhau);

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBS = edtTen.getText().toString();
                String ngaySinh = edtNgaySinh.getText().toString();
                String gioiTinh = edtGioiTinh.getText().toString();
                String phone = edtSDT.getText().toString();
                String diaChi = edtDiachi.getText().toString();
                String TK = edtTK.getText().toString();
                String MK = edtMK.getText().toString();


                if ( tenBS.equals("") ||  phone.equals("") || diaChi.equals("") || ngaySinh.equals("")|| gioiTinh.equals("")|| TK.equals("")|| MK.equals("")) {
                    if (tenBS.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show();
                    } else if (phone.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    } else if (ngaySinh.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập ngày sinh", Toast.LENGTH_SHORT).show();
                    } else if (diaChi.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập địa chỉ", Toast.LENGTH_SHORT).show();
                    } else if (gioiTinh.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập giới tính", Toast.LENGTH_SHORT).show();
                    } else if (TK.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
                    }else if (MK.equals("")) {
                        Toast.makeText(ThemTKNguoiDungActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    QuanLyTKNguoiDungActivity.databaseTKNguoiDung.INSERT_TKNguoiDung(
                            edtTen.getText().toString().trim(),
                            edtNgaySinh.getText().toString().trim(),
                            edtGioiTinh.getText().toString().trim(),
                            Integer.parseInt(edtSDT.getText().toString().trim()),
                            edtDiachi.getText().toString().trim(),
                            edtTK.getText().toString().trim(),
                            edtMK.getText().toString().trim()
                    );
                    Toast.makeText(ThemTKNguoiDungActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ThemTKNguoiDungActivity.this,QuanLyTKNguoiDungActivity.class);
                    startActivity(i);

                }
            }

        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemTKNguoiDungActivity.this,QuanLyTKNguoiDungActivity.class);
                startActivity(i);
            }
        });
    }
}