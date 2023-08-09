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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhSachThuocActivity extends AppCompatActivity {
    View imgThem;

    Button imgback4;
    ListView lvThuoc;
    ArrayList<Thuoc> thuocList;
    ThuocAdapter thuocAdapter;
    public static DatabaseThuoc databaseThuoc;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_thuoc);
        imgThem=(View) findViewById(R.id.imgThem);
        imgback4 = (Button) findViewById(R.id.imgBack3);
        lvThuoc=(ListView) findViewById(R.id.lvThuoc);
        thuocList=new ArrayList<>();
        thuocAdapter=new ThuocAdapter(this,R.layout.thuoc,thuocList);
        lvThuoc.setAdapter(thuocAdapter);

        imgback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(DanhSachThuocActivity.this,TrangHomeBacSiActivity.class);
                startActivity(i);
            }
        });

        databaseThuoc=new DatabaseThuoc(this,"AppQuanLySucKhoe",null,1);
        databaseThuoc.QueryData("CREATE TABLE IF NOT EXISTS Thuoc(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TenBenhNhan VARCHAR(30)," +
                "TenThuoc VARCHAR(30)," +
                " SoLuong VARCHAR(30), " +
                "CongDung VARCHAR(30)," +
                "NgayBD VARCHAR(15), " +
                "NgayKT VARCHAR(15)" +
                ");");
        //get data
        GetDataThuoc();
        imgThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DanhSachThuocActivity.this,ThuocActivity.class);
                startActivity(i);
            }
        });
    }
    public void GetDataThuoc(){
        Cursor cursor= databaseThuoc.GetData("SELECT * FROM Thuoc");
        while (cursor.moveToNext()){
            thuocList.add(new Thuoc(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)


            ));
        }
        thuocAdapter.notifyDataSetChanged();
    }
    public void XoaThuoc(int id){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setTitle("Bạn có muốn xóa ?");
        dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseThuoc.QueryData("DELETE FROM Thuoc WHERE Id='"+id+"'");
                Toast.makeText(DanhSachThuocActivity.this, "Đã xóa ", Toast.LENGTH_SHORT).show();
                thuocList.clear();
                GetDataThuoc();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });;
        dialogXoa.show();
    }
    public  void SuaThuoc(int id, String maBN,String tenThuoc,String soluong,String congDung, String ngayBD,String ngayKT){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.suathuoc);
        EditText edtMa=(EditText) dialog.findViewById(R.id.edtMaBN);
        EditText edtTen=(EditText) dialog.findViewById(R.id.edtTenThuoc);
        EditText edtSoluong=(EditText) dialog.findViewById(R.id.edtSoluong);
        EditText edtCongDung=(EditText) dialog.findViewById(R.id.edtCongDung);
        EditText edtNgayBD=(EditText) dialog.findViewById(R.id.edtNgayBD);
        EditText edtNgayKT=(EditText) dialog.findViewById(R.id.edtNgayKT);
        Button mbtnXacNhan=(Button) dialog.findViewById(R.id.btnEdit);
        Button mbtnHuy=(Button) dialog.findViewById(R.id.btnHuy);
        edtMa.setText(maBN);
        edtTen.setText(tenThuoc);
        edtSoluong.setText(soluong);
        edtCongDung.setText(congDung);
        edtNgayBD.setText(ngayBD);
        edtNgayKT.setText(ngayKT);
        mbtnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medtMaBenhNhanMoi=edtMa.getText().toString().trim();
                String medtTenThuoc=edtTen.getText().toString().trim();
                String medtSoLuong=edtSoluong.getText().toString().trim();
                String medtCongDung=edtCongDung.getText().toString().trim();
                String medtNgayBD=edtNgayBD.getText().toString().trim();
                String medtNgayKT=edtNgayKT.getText().toString().trim();
                //update database
                databaseThuoc.QueryData("UPDATE Thuoc SET TenBenhNhan='"+medtMaBenhNhanMoi+"',TenThuoc='"+medtTenThuoc+"',SoLuong='"+medtSoLuong+"',CongDung='"+medtCongDung+"',NgayBD='"+medtNgayBD+"',NgayKT='"+medtNgayKT+"'WHERE Id='"+id+"'");
                Toast.makeText(DanhSachThuocActivity.this,"Đã cập nhật",Toast.LENGTH_SHORT).show();
                dialog.cancel();
                thuocList.clear();
                GetDataThuoc();
            }
        });
        mbtnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}