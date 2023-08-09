package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuanLyTKNguoiDungActivity extends AppCompatActivity {

    View imgThem;
    Button imgback;
    ListView lvTKNguoiDung;
    ArrayList<BenhNhan> benhNhans;
    TKNguoiDungAdapter adapterTKNguoiDung;
    public static DatabaseTKNguoiDung databaseTKNguoiDung;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tknguoi_dung);
        imgback=(Button) findViewById(R.id.imgBack3);
        imgThem=(View) findViewById(R.id.imgThem);
        lvTKNguoiDung=(ListView) findViewById(R.id.lvTKNguoiDung);
        benhNhans=new ArrayList<>();
        adapterTKNguoiDung=new TKNguoiDungAdapter(this,R.layout.tk_nguoidung,benhNhans);
        lvTKNguoiDung.setAdapter(adapterTKNguoiDung);
        databaseTKNguoiDung=new DatabaseTKNguoiDung(this,"AppQuanLySucKhoe",null,1);
        databaseTKNguoiDung.QueryData("CREATE TABLE IF NOT EXISTS TKCaNhan(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Ten VARCHAR(30), " +
                "NgaySinh VARCHAR(100)," +
                "GioiTinh VARCHAR(100)," +
                "Phone INTEGER, " +
                "DiaChi VARCHAR(30)," +
                "TaiKhoan VARCHAR(100)," +
                "MatKhau VARCHAR(100)" +
                ");");
        //get data
        GetDataTKCaNhan();
        imgThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuanLyTKNguoiDungActivity.this,ThemTKNguoiDungActivity.class);
                startActivity(intent);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuanLyTKNguoiDungActivity.this,QuanLyTKAdminActivity.class);
                startActivity(intent);
            }
        });
    }
    public void GetDataTKCaNhan(){
        Cursor cursor= databaseTKNguoiDung.GetData("SELECT * FROM TKCaNhan");
        while (cursor.moveToNext()){
            benhNhans.add(new BenhNhan(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
            ));
        }
        adapterTKNguoiDung.notifyDataSetChanged();
    }
    public void XoaTKNguoiDung(int id,String ten){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setTitle("Bạn muốn xóa : "+ten+" ?");
        dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseTKNguoiDung.QueryData("DELETE FROM TKCaNhan WHERE Id='"+id+"'");
                Toast.makeText(QuanLyTKNguoiDungActivity.this, "Đã xóa  "+ten, Toast.LENGTH_SHORT).show();
                benhNhans.clear();
                GetDataTKCaNhan();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });;
        dialogXoa.show();
    }
    public void XemChiTiet(String tenBacSi,String ngaySinh,String gioiTinh,int soDienThoai,String diaChi,String taiKhoan,String matKhau) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.xem_thong_tin_ca_nhan);
        TextView txtTenBN = (TextView) dialog.findViewById(R.id.edtTenBacSi);
        TextView txtNgaySinh = (TextView) dialog.findViewById(R.id.edtNgaySinh);
        TextView txtGioiTinh = (TextView) dialog.findViewById(R.id.edtGioiTinh);
        TextView txtPhone = (TextView) dialog.findViewById(R.id.edtSDT);
        TextView txtDiaChi = (TextView) dialog.findViewById(R.id.edtDiaChi);
        TextView txtTK = (TextView) dialog.findViewById(R.id.edtTenTK);
        TextView txtMK = (TextView) dialog.findViewById(R.id.edtMatKhau);
        Button mbtnThoat = (Button) dialog.findViewById(R.id.btnHuy);
        txtTenBN.setText(tenBacSi);
        txtNgaySinh.setText(ngaySinh);
        txtGioiTinh.setText(gioiTinh);
        txtPhone.setText(String.valueOf(soDienThoai));
        txtDiaChi.setText(diaChi);
        txtTK.setText(taiKhoan);
        txtMK.setText(matKhau);
        mbtnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}