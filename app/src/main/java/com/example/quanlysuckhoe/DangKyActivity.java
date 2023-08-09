package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DangKyActivity extends AppCompatActivity {

    TextView txtCoTK;
    EditText medtTen,medtGT,medtSDT,medtUser,medtPass;
    Button btnDK;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        btnDK=(Button) findViewById(R.id.btnDangKy);
        medtGT=(EditText) findViewById(R.id.edtGioiTinh);
        medtTen=(EditText) findViewById(R.id.fullname);
        medtSDT=(EditText) findViewById(R.id.edtSDT);
        medtUser=(EditText) findViewById(R.id.username);
        medtPass=(EditText) findViewById(R.id.password);
        txtCoTK=(TextView) findViewById(R.id.bandacotaikhoan);

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DangKyActivity.this,"Đăng kí thành công", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
        txtCoTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
}