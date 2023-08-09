package com.example.quanlysuckhoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TiemPhongActivity extends AppCompatActivity {

    Button imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiem_phong);
        imgBack=(Button) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TiemPhongActivity.this,DichVuChamSocBenhNhanActivity.class);
                startActivity(intent);
            }
        });
    }
}