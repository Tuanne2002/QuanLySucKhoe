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
import android.widget.TextView;
import android.widget.Toast;

public class ThuocActivity extends AppCompatActivity {
    Button mbtnThemThuoc,mbtnHuy;

    EditText medtSoLuong,medtTenThuoc,medtCongDung,medtNgayBD,medtNgayKT,medtTenBN,medtMaBN;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc);
        medtMaBN=(EditText) findViewById(R.id.edtMaBenhNhan);
        mbtnThemThuoc = (Button) findViewById(R.id.btnThemThuoc);
        mbtnHuy = (Button) findViewById(R.id.btnXoa);
        medtTenBN=(EditText) findViewById(R.id.edtTenBenhNhan);
        medtSoLuong = (EditText) findViewById(R.id.edtsoluong);
        medtTenThuoc = (EditText) findViewById(R.id.edtTenTThuoc);
        medtCongDung = (EditText) findViewById(R.id.edtCachDung);
        medtNgayBD = (EditText) findViewById(R.id.edtNBD);
        medtNgayKT = (EditText) findViewById(R.id.edtNKT);

        mbtnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder d=new AlertDialog.Builder(ThuocActivity.this);
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
                        Intent intent= new Intent(ThuocActivity.this,DanhSachThuocActivity.class);
                        startActivity(intent);
                    }
                });
                d.create().show();
            }
        });
        mbtnThemThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maBN =medtMaBN.getText().toString();
                String tenBN = medtTenBN.getText().toString();
                String tenThuoc = medtTenThuoc.getText().toString();
                String soluong = medtSoLuong.getText().toString();
                String cachdungThuoc = medtCongDung.getText().toString();
                String ngayBd =medtNgayBD.getText().toString();
                String ngayKt = medtNgayKT.getText().toString();

                if (maBN.equals("") ||tenThuoc.equals("") || soluong.equals("") || cachdungThuoc.equals("") || ngayBd.equals("") || ngayKt.equals("")||tenBN.equals("")) {
                    if (maBN.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập mã bệnh nhân", Toast.LENGTH_SHORT).show();
                    } else if (tenBN.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập tên bệnh nhân", Toast.LENGTH_SHORT).show();
                    }else if (tenThuoc.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập mã thuốc", Toast.LENGTH_SHORT).show();
                    } else if (soluong.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập tên thuốc", Toast.LENGTH_SHORT).show();
                    } else if (cachdungThuoc.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập tác dụng thuốc", Toast.LENGTH_SHORT).show();
                    } else if (ngayBd.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập ngày sản xuất", Toast.LENGTH_SHORT).show();
                    } else if (ngayKt.equals("")) {
                        Toast.makeText(ThuocActivity.this, "Vui lòng nhập hạn sử dụng", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    DanhSachThuocActivity.databaseThuoc.INSERT_Thuoc(
                           // medtMaBN.getText().toString().trim(),
                            medtTenBN.getText().toString().trim(),
                            medtTenThuoc.getText().toString().trim(),
                            medtSoLuong.getText().toString().trim(),
                            medtCongDung.getText().toString().trim(),
                            medtNgayBD.getText().toString().trim(),
                            medtNgayKT.getText().toString().trim()
                    );


                    Toast.makeText(ThuocActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ThuocActivity.this, DanhSachThuocActivity.class);
                    startActivity(intent);

                }
            }
        });

    }
}