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

public class ThemLichSuKhamActivity extends AppCompatActivity {

    Button mbtnThem,mbtnHuy;

    EditText medtTenBenh,medtLyDo,medTime;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lich_su_kham);

        mbtnHuy = (Button) findViewById(R.id.btnHuyB);
        mbtnThem = (Button) findViewById(R.id.btnThemB);
        medtTenBenh = (EditText) findViewById(R.id.edtbenh);
        medtLyDo = (EditText) findViewById(R.id.edtLiDo);
        medTime = (EditText) findViewById(R.id.edtime);

        mbtnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder d=new AlertDialog.Builder(ThemLichSuKhamActivity.this);
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
                        Intent intent= new Intent(ThemLichSuKhamActivity.this,LichSuBenhAnActivity.class);
                        startActivity(intent);
                    }
                });
                d.create().show();
            }
        });

        mbtnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenbenh = medtTenBenh.getText().toString();
                String lydo = medtLyDo.getText().toString();
                String time = medTime.getText().toString();

                if (tenbenh.equals("") || lydo.equals("") || time.equals("") ) {
                    if (tenbenh.equals("")) {
                        Toast.makeText(ThemLichSuKhamActivity.this, "Vui lòng nhập tên bệnh", Toast.LENGTH_SHORT).show();
                    } else if (lydo.equals("")) {
                        Toast.makeText(ThemLichSuKhamActivity.this, "Vui lòng nhập lý do bệnh", Toast.LENGTH_SHORT).show();
                    } else if (time.equals("")) {
                        Toast.makeText(ThemLichSuKhamActivity.this, "Vui lòng nhập thời gian điều trị", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    LichSuBenhAnActivity.databaseLichSuBenh.INSERT_LichSuBenh(

                            medtTenBenh.getText().toString().trim(),
                            medtLyDo.getText().toString().trim(),

                            medTime.getText().toString().trim()
                    );
                    Toast.makeText(ThemLichSuKhamActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ThemLichSuKhamActivity.this, LichSuBenhAnActivity.class);
                    startActivity(intent);

                }
            }

        });

    }
}