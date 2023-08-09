package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemTKBacSiActivity extends AppCompatActivity {

    Button btnCapNhat, huy;
    EditText edtTen, edtSDT, edtDiachi,edtChuyenKhoa,edtKinhNghiem,edtTK,edtMK,edtVT;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tkbac_si);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        huy = (Button) findViewById(R.id.btnHuy);
        edtTen = (EditText) findViewById(R.id.edtTenBacSi);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        edtDiachi = (EditText) findViewById(R.id.edtDiaChi);
        edtChuyenKhoa = (EditText) findViewById(R.id.edtChuyenKhoa);
        edtKinhNghiem = (EditText) findViewById(R.id.edtKinhNghiem);
        edtTK = (EditText) findViewById(R.id.edtTenTK);
        edtMK = (EditText) findViewById(R.id.edtMatKhau);
        edtVT = (EditText) findViewById(R.id.edtVaiTro);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBS = edtTen.getText().toString();
                String phone = edtSDT.getText().toString();
                String diaChi = edtDiachi.getText().toString();
                String chuyenKhoa = edtChuyenKhoa.getText().toString();
                String kinhNghiem = edtKinhNghiem.getText().toString();
                String TK = edtTK.getText().toString();
                String MK = edtMK.getText().toString();
                String VT = edtVT.getText().toString();

                if ( tenBS.equals("") ||  phone.equals("") || diaChi.equals("") || chuyenKhoa.equals("")|| kinhNghiem.equals("")|| TK.equals("")|| MK.equals("") ) {
                    if (tenBS.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show();
                    } else if (phone.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    } else if (chuyenKhoa.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập chuyên khoa", Toast.LENGTH_SHORT).show();
                    } else if (diaChi.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập địa chỉ", Toast.LENGTH_SHORT).show();
                    } else if (kinhNghiem.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập kinh nghiệm", Toast.LENGTH_SHORT).show();
                    } else if (TK.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
                    }else if (MK.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    }else if (VT.equals("")) {
                        Toast.makeText(ThemTKBacSiActivity.this, "Vui lòng nhập vai trò", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    QuanLyTKBacSiActivity.databaseTKBacSi.INSERT_TKBacSi(
                            edtTen.getText().toString().trim(),
                            Integer.parseInt(edtSDT.getText().toString().trim()),
                            edtDiachi.getText().toString().trim(),
                            edtChuyenKhoa.getText().toString().trim(),
                            edtKinhNghiem.getText().toString().trim(),
                            edtTK.getText().toString().trim(),
                            edtMK.getText().toString().trim(),
                            edtVT.getText().toString().trim()
                    );
                    Toast.makeText(ThemTKBacSiActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ThemTKBacSiActivity.this,QuanLyTKBacSiActivity.class);
                    startActivity(i);

                }
            }

        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThemTKBacSiActivity.this,QuanLyTKBacSiActivity.class);
                startActivity(i);
            }
        });
    }
}