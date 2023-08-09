package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemBacSiActivity extends AppCompatActivity {
    Button mbtnThem,mbtnHuy;

    EditText medtMaBS,medtTenBS,medtChuyenKhoa,medtSDT,medtKinhNghiem;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_bac_si);
        mbtnHuy=(Button) findViewById(R.id.btnHuy);
        mbtnThem=(Button) findViewById(R.id.btnThem);
        medtMaBS=(EditText) findViewById(R.id.edtMaBacSi);
        medtTenBS=(EditText) findViewById(R.id.edtTenBacSi);
        medtChuyenKhoa=(EditText) findViewById(R.id.edtChuyenKhoa);
        medtSDT=(EditText) findViewById(R.id.edtSoDienThoai);
        medtKinhNghiem=(EditText) findViewById(R.id.edtKinhNghiem);

        mbtnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder d=new AlertDialog.Builder(ThemBacSiActivity.this);
                d.setTitle("Bạn có chắc hủy ?");
                d.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                d.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(ThemBacSiActivity.this,BacSiTuVanActivity.class);
                        startActivity(intent);
                    }
                });
                d.create().show();
            }
        });

        mbtnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maBS = medtMaBS.getText().toString();
                String tenBS = medtTenBS.getText().toString();
                String chuyenKhoa = medtChuyenKhoa.getText().toString();
                String SDT = medtSDT.getText().toString();
                String kinhNghiem = medtKinhNghiem.getText().toString();

                if (maBS.equals("") || tenBS.equals("") || chuyenKhoa.equals("") || SDT.equals("") || kinhNghiem.equals("")) {
                    if (maBS.equals("")) {
                        Toast.makeText(ThemBacSiActivity.this, "Vui lòng nhập mã bác sĩ", Toast.LENGTH_SHORT).show();
                    } else if (tenBS.equals("")) {
                        Toast.makeText(ThemBacSiActivity.this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show();
                    } else if (chuyenKhoa.equals("")) {
                        Toast.makeText(ThemBacSiActivity.this, "Vui lòng nhập chuyên khoa", Toast.LENGTH_SHORT).show();
                    } else if (SDT.equals("")) {
                        Toast.makeText(ThemBacSiActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    } else if (kinhNghiem.equals("")) {
                        Toast.makeText(ThemBacSiActivity.this, "Vui lòng nhập kinh nghiệm", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    BacSiTuVanActivity.databaseBacSi.INSERT_BacSi(
                            medtMaBS.getText().toString().trim(),
                            medtTenBS.getText().toString().trim(),
                            medtChuyenKhoa.getText().toString().trim(),
                            Integer.parseInt(medtSDT.getText().toString().trim()),
                            medtKinhNghiem.getText().toString().trim()
                    );
                    Toast.makeText(ThemBacSiActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ThemBacSiActivity.this, BacSiTuVanActivity.class);
                    startActivity(intent);

                }
            }

        });
    }
}