package com.example.quanlysuckhoe;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HoSoBenhNhanActivity extends AppCompatActivity {

    Button thembenh, imgback2;
    ListView lvbenhnhan;
    ArrayList<BenhNhan> arraybenhnhan;
    BenhNhanAdapter benhNhanAdapter;
    public static  DatabaseBenhNhan databaseBenhNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_benh_nhan);
        thembenh = (Button) findViewById(R.id.thembenhnhan);
        imgback2 = (Button) findViewById(R.id.imgBack2);
        lvbenhnhan = (ListView)findViewById(R.id.lvBenhNhan);
        arraybenhnhan = new ArrayList<>();
        benhNhanAdapter = new BenhNhanAdapter(this,R.layout.benh_nhan,arraybenhnhan);
        lvbenhnhan.setAdapter(benhNhanAdapter);

        imgback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoSoBenhNhanActivity.this,TrangHomeBacSiActivity.class);
                startActivity(i);
            }
        });

        databaseBenhNhan = new DatabaseBenhNhan(this,"AppQuanLySucKhoe",null,1);
        databaseBenhNhan.QueryData("CREATE TABLE IF NOT EXISTS BenhNhan(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaBenhNhan VARCHAR(10) , " +
                "Ten VARCHAR(30), " +
                "GioiTinh VARCHAR(5),DiaChi VARCHAR(100)," +
                "Phone INTEGER," +
                "BenhAn VARCHAR(100)"+
        ");");

        GetDataBenhNhan();


        thembenh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoSoBenhNhanActivity.this,ThemBenhNhanActivity.class);
                startActivity(i);
            }
        });


    }

    public void GetDataBenhNhan(){
        Cursor cursor = databaseBenhNhan.GetData("SELECT * FROM BenhNhan");
        while (cursor.moveToNext()){
            arraybenhnhan.add(new BenhNhan(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getString(6)
            ));
        }
        benhNhanAdapter.notifyDataSetChanged();
    }

    public void XoaBenhNhan(int id,String ten){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setTitle("Bạn muốn xóa bệnh nhân: "+ten+" ?");
        dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseBenhNhan.QueryData("DELETE FROM BenhNhan WHERE Id='"+id+"'");
                Toast.makeText(HoSoBenhNhanActivity.this, "Đã xóa bệnh nhân "+ten, Toast.LENGTH_SHORT).show();
                arraybenhnhan.clear();
                GetDataBenhNhan();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });;
        dialogXoa.show();
    }
    public  void SuaThongTin(int id, String maBenhNhan,String tenBanhNhan,String gioiTinh,String diaChi,int phone, String benhAn){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sua_thong_tin_benh_nhan);
        EditText edtMa=(EditText) dialog.findViewById(R.id.edtMaBenhNhan);
        EditText edtTen=(EditText) dialog.findViewById(R.id.edtTenBenhNhan);
        EditText edtGT=(EditText) dialog.findViewById(R.id.edtGioiTinh);
        EditText edtDiachi=(EditText) dialog.findViewById(R.id.edtDiaChi);
        EditText edtSDT=(EditText) dialog.findViewById(R.id.edtPhone);
        EditText edtbenhan=(EditText) dialog.findViewById(R.id.edtBenhAn);
        Button mbtnXacNhan=(Button) dialog.findViewById(R.id.btnEdit);
        Button mbtnHuy=(Button) dialog.findViewById(R.id.btnHuy);
        edtMa.setText(String.valueOf(maBenhNhan));
        edtTen.setText(tenBanhNhan);
        edtGT.setText(gioiTinh);
        edtDiachi.setText(diaChi);
        edtSDT.setText(String.valueOf(phone));
        edtbenhan.setText(benhAn);
        mbtnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medtMaBenhNhanMoi=edtMa.getText().toString().trim();
                String medtTenBenhNhanMoi=edtTen.getText().toString().trim();
                String medtGioiTinhMoi=edtGT.getText().toString().trim();
                String medtDiaChiMoi=edtDiachi.getText().toString().trim();
                String medtSDTMoi=edtSDT.getText().toString().trim();
                String medtBenhAnMoi=edtbenhan.getText().toString().trim();
                //update database
                databaseBenhNhan.QueryData("UPDATE BenhNhan SET MaBenhNhan='"+medtMaBenhNhanMoi+"',Ten='"+medtTenBenhNhanMoi+"',GioiTinh='"+medtGioiTinhMoi+"',DiaChi='"+medtDiaChiMoi+"',Phone='"+medtSDTMoi+"',BenhAn='"+medtBenhAnMoi+"' WHERE Id='"+id+"'");
                Toast.makeText(HoSoBenhNhanActivity.this,"Đã cập nhật",Toast.LENGTH_SHORT).show();
                dialog.cancel();
                arraybenhnhan.clear();
                GetDataBenhNhan();
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
    public void XemChiTiet(String MaBN,String ten,String gioiTinh,String diaChi,int phone,String benhAn) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.xem_thong_tin_benh_nhan);
        TextView txtMaBN = (TextView) dialog.findViewById(R.id.txtMaBenhNhan);
        TextView txtTenBN = (TextView) dialog.findViewById(R.id.txtTenBenhNhan);
        TextView txtGioiTinh = (TextView) dialog.findViewById(R.id.txtGioiTinh);
        TextView txtDiaChi = (TextView) dialog.findViewById(R.id.txtDiaChi);
        TextView txtPhone = (TextView) dialog.findViewById(R.id.txtPhone);
        TextView txtBenhAn = (TextView) dialog.findViewById(R.id.txtBenhAn);
        Button mbtnThoat = (Button) dialog.findViewById(R.id.btnThoat);
        txtMaBN.setText(String.valueOf(MaBN));
        txtTenBN.setText(ten);
        txtGioiTinh.setText(gioiTinh);
        txtDiaChi.setText(diaChi);
        txtPhone.setText(String.valueOf(phone));
        txtBenhAn.setText(benhAn);
        mbtnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}