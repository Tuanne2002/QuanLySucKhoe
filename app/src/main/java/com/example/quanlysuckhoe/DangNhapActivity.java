package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhapActivity extends AppCompatActivity {

    EditText username, password;
    Button login,create;

    public static DatabaseTKNguoiDung databaseTKNguoiDung;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        create=(Button) findViewById(R.id.create);
        databaseTKNguoiDung=new DatabaseTKNguoiDung(this,"AppQuanLySucKhoe",null,1);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();



                // Kiểm tra thông tin đăng nhập trong SQLite (trong ví dụ này, sử dụng tên người dùng và mật khẩu mặc định)
                if (user.equals("admin") && pass.equals("123456")) {
                    // Đăng nhập thành công, phân quyền người dùng tại đây (ví dụ: mở một Activity khác)
                    Toast.makeText(DangNhapActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,QuanLyTKAdminActivity.class);
                    startActivity(i);
                    // Thực hiện chuyển đến Activity phân quyền người dùng
                    // Intent intent = new Intent(MainActivity.this, PermissionActivity.class);
                    // startActivity(intent);
                } else if (user.equals("quocanh") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeActivity.class);
                    startActivity(i);
                }else if (user.equals("tuanlinh") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeActivity.class);
                    startActivity(i);
                }
                else if (user.equals("anhtuan") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeActivity.class);
                    startActivity(i);
                }
                else if (user.equals("quoctuan") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeActivity.class);
                    startActivity(i);
                }
                else if (user.equals("bsquocanh") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeBacSiActivity.class);
                    startActivity(i);
                }
                else if (user.equals("bstuanlinh") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeBacSiActivity.class);
                    startActivity(i);
                }
                else if (user.equals("bsanhtuan") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeBacSiActivity.class);
                    startActivity(i);
                }
                else if (user.equals("bsquoctuan") && pass.equals("123456")) {
                    Toast.makeText(DangNhapActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangNhapActivity.this,TrangHomeBacSiActivity.class);
                    startActivity(i);
                }
                else {
                    // Đăng nhập thất bại
                    Toast.makeText(DangNhapActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
}