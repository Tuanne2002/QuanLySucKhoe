package com.example.quanlysuckhoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DichVuChamSocActivity extends AppCompatActivity {
    Button imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vu_cham_soc);
        imgback = (Button) findViewById(R.id.imgBack);



        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DichVuChamSocActivity.this,TrangHomeBacSiActivity.class);
                startActivity(i);
            }
        });
    }
}