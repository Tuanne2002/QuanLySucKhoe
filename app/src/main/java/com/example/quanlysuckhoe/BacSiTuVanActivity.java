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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BacSiTuVanActivity extends AppCompatActivity {
    View imgThem;
    Button imgback3;
    //ImageView imgThem,imgBack;
    ListView lvBacSi;
    ArrayList<BacSi> bacSis;
    BacSiAdapter adapterBacSi;
    public static DatabaseBacSi databaseBacSi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_si_tu_van);
        imgThem=(View) findViewById(R.id.imgThem);
        imgback3 = (Button)findViewById(R.id.imgBack3);
        lvBacSi=(ListView) findViewById(R.id.lvBacSi);

        imgback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(BacSiTuVanActivity.this,QuanLyTKAdminActivity.class);
                startActivity(i);
            }
        });

        bacSis=new ArrayList<>();
        adapterBacSi=new BacSiAdapter(this,R.layout.bacsi,bacSis);
        lvBacSi.setAdapter(adapterBacSi);
        databaseBacSi=new DatabaseBacSi(this,"AppQuanLySucKhoe",null,1);
        databaseBacSi.QueryData("CREATE TABLE IF NOT EXISTS BacSi(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaBacSi VARCHAR(10) ," +
                " Ten VARCHAR(30), " +
                "ChuyenKhoa VARCHAR(30)," +
                "Phone INTEGER, " +
                "KinhNghiem VARCHAR(100)" +
                ");");
        //get data
        GetDataBacSi();
        imgThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(BacSiTuVanActivity.this,ThemBacSiActivity.class);
                startActivity(intent);
            }
        });
    }
    public void GetDataBacSi(){
        Cursor cursor= databaseBacSi.GetData("SELECT * FROM BacSi");
        while (cursor.moveToNext()){
            bacSis.add(new BacSi(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5)

            ));
        }
        adapterBacSi.notifyDataSetChanged();
    }
    public void XoaBacSi(int id,String ten){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setTitle("Bạn muốn xóa bác sĩ: "+ten+" ?");
        dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseBacSi.QueryData("DELETE FROM BacSi WHERE Id='"+id+"'");
                Toast.makeText(BacSiTuVanActivity.this, "Đã xóa bác sĩ "+ten, Toast.LENGTH_SHORT).show();
                bacSis.clear();
                GetDataBacSi();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });;
        dialogXoa.show();
    }
    public  void SuaBacSi(int id, String maBacSi,String tenBacSi,String chuyenKhoa,int phone, String kinhNghiem){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sua_thong_tin_bs);
        EditText edtMa=(EditText) dialog.findViewById(R.id.edtMaBacSi);
        EditText edtTen=(EditText) dialog.findViewById(R.id.edtTenBacSi);
        EditText edtchuyenKhoa=(EditText) dialog.findViewById(R.id.edtChuyenKhoa);
        EditText edtSDT=(EditText) dialog.findViewById(R.id.edtPhone);
        EditText edtkinhNghiem=(EditText) dialog.findViewById(R.id.edtKinhNghiem);
        Button mbtnXacNhan=(Button) dialog.findViewById(R.id.btnEdit);
        Button mbtnHuy=(Button) dialog.findViewById(R.id.btnHuy);
        edtMa.setText(maBacSi);
        edtTen.setText(tenBacSi);
        edtchuyenKhoa.setText(chuyenKhoa);
        edtSDT.setText(String.valueOf(phone));
        edtkinhNghiem.setText(kinhNghiem);
        mbtnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medtMaBenhNhanMoi=edtMa.getText().toString().trim();
                String medtTenBenhNhanMoi=edtTen.getText().toString().trim();
                String medtDiaChiMoi=edtchuyenKhoa.getText().toString().trim();
                String medtSDTMoi=edtSDT.getText().toString().trim();
                String medtBenhAnMoi=edtkinhNghiem.getText().toString().trim();
                //update database
                databaseBacSi.QueryData("UPDATE BacSi SET MaBacSi='"+medtMaBenhNhanMoi+"',Ten='"+medtTenBenhNhanMoi+"',ChuyenKhoa='"+medtDiaChiMoi+"',Phone='"+medtSDTMoi+"',KinhNghiem='"+medtBenhAnMoi+"' WHERE Id='"+id+"'");
                Toast.makeText(BacSiTuVanActivity.this,"Đã cập nhật",Toast.LENGTH_SHORT).show();
                dialog.cancel();
                bacSis.clear();
                GetDataBacSi();
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
    public void XemChiTiet(String MaBS,String ten,String chuyenKhoa,int phone,String kinhNghiem) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.xem_thong_tin_bac_si);
        TextView txtMaBS = (TextView) dialog.findViewById(R.id.txtMaBS);
        TextView txtTenBS = (TextView) dialog.findViewById(R.id.txtTenBS);
        TextView txtChuyenKhoa = (TextView) dialog.findViewById(R.id.txtCK);
        TextView txtPhone = (TextView) dialog.findViewById(R.id.txtsdtBS);
        TextView txtKinhNghiem = (TextView) dialog.findViewById(R.id.txtKN);
        Button mbtnThoat = (Button) dialog.findViewById(R.id.btnThoat);
        txtMaBS.setText(MaBS);
        txtTenBS.setText(ten);
        txtChuyenKhoa.setText(chuyenKhoa);
        txtPhone.setText(String.valueOf(phone));
        txtKinhNghiem.setText(kinhNghiem);
        mbtnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}