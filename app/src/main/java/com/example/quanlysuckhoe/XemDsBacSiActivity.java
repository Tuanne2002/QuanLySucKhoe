package com.example.quanlysuckhoe;

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

public class XemDsBacSiActivity extends AppCompatActivity {
    View imgThem;
    Button imgback3;
    //ImageView imgThem,imgBack;
    ListView lvBacSi;
    ArrayList<BacSi> bacSis;
    XemBacSiAdapter adapterXemBacSi;
    public static DatabaseBacSi databaseBacSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_ds_bac_si);
        imgback3 = (Button)findViewById(R.id.imgBack3);
        lvBacSi=(ListView) findViewById(R.id.lvBacSi);

        imgback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(XemDsBacSiActivity.this,TrangHomeActivity.class);
                startActivity(i);
            }
        });

        bacSis=new ArrayList<>();
        adapterXemBacSi=new XemBacSiAdapter(this,R.layout.xembacsi,bacSis);
        lvBacSi.setAdapter(adapterXemBacSi);
        databaseBacSi=new DatabaseBacSi(this,"AppQuanLySucKhoe",null,1);
        databaseBacSi.QueryData("CREATE TABLE IF NOT EXISTS BacSi(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaBacSi INTEGER ," +
                " Ten VARCHAR(30), " +
                "ChuyenKhoa VARCHAR(30)," +
                "Phone INTEGER, " +
                "KinhNghiem VARCHAR(100)" +
                ");");
        //get data
        GetDataBacSi();

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
        adapterXemBacSi.notifyDataSetChanged();
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