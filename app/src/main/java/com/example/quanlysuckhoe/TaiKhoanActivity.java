package com.example.quanlysuckhoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaiKhoanActivity extends AppCompatActivity {
    Button chitiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        chitiet = (Button) findViewById(R.id.chi_ti_t);

        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TaiKhoanActivity.this,LichSuBenhAnActivity.class);
                startActivity(i);
            }
        });
    }
}