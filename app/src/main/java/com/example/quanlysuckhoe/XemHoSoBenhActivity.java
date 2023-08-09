package com.example.quanlysuckhoe;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class XemHoSoBenhActivity extends AppCompatActivity {

    Button thembenh, imgback2;
    ListView lvbenhnhan;
    ArrayList<BenhNhan> arraybenhnhan;
    XemBenhNhanAdapter benhNhanAdapter;
    public static  DatabaseBenhNhan databaseBenhNhan;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_ho_so_benh);
        imgback2 = (Button) findViewById(R.id.imgBack2);
        lvbenhnhan = (ListView)findViewById(R.id.lvBenhNhan);
        arraybenhnhan = new ArrayList<>();
        benhNhanAdapter = new XemBenhNhanAdapter(this,R.layout.xembenhnhan,arraybenhnhan);
        lvbenhnhan.setAdapter(benhNhanAdapter);

        imgback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(XemHoSoBenhActivity.this,TrangHomeActivity.class);
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