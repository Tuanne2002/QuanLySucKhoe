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

public class QuanLyTKBacSiActivity extends AppCompatActivity {


    View imgThem ;
    Button imgback;
    ListView lvTKBacSi;
    ArrayList<BacSi> bacSis;
    TKBacSiAdapter adapterTKBacSi;
    public static DatabaseTKBacSi databaseTKBacSi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tkbac_si);
        imgThem=(View) findViewById(R.id.imgThem);
        imgback=(Button) findViewById(R.id.imgBack3) ;
        lvTKBacSi=(ListView) findViewById(R.id.lvTKBacSi);
        bacSis=new ArrayList<>();
        adapterTKBacSi=new TKBacSiAdapter(this,R.layout.tk_bac_si,bacSis);
        lvTKBacSi.setAdapter(adapterTKBacSi);
        databaseTKBacSi=new DatabaseTKBacSi(this,"AppQuanLySucKhoe",null,1);
        databaseTKBacSi.QueryData("CREATE TABLE IF NOT EXISTS TKBacSi(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Ten VARCHAR(30), " +
                "Phone INTEGER, " +
                "DiaChi VARCHAR(30)," +
                "ChuyenKhoa VARCHAR(100)," +
                "KinhNghiem VARCHAR(100)," +
                "TaiKhoan VARCHAR(100)," +
                "MatKhau VARCHAR(100)," +
                "VaiTro VARCHAR(100)" +
                ");");
        //get data
        GetDataTKBacSi();
        imgThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuanLyTKBacSiActivity.this,ThemTKBacSiActivity.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuanLyTKBacSiActivity.this,QuanLyTKAdminActivity.class);
                startActivity(intent);
            }
        });
    }
    public void GetDataTKBacSi(){
        Cursor cursor= databaseTKBacSi.GetData("SELECT * FROM TKBacSi");
        while (cursor.moveToNext()){
            bacSis.add(new BacSi(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)

            ));
        }
        adapterTKBacSi.notifyDataSetChanged();
    }
    public void XoaTKBacSi(int id,String ten){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setTitle("Bạn muốn xóa : "+ten+" ?");
        dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseTKBacSi.QueryData("DELETE FROM TKBacSi WHERE Id='"+id+"'");
                Toast.makeText(QuanLyTKBacSiActivity.this, "Đã xóa  "+ten, Toast.LENGTH_SHORT).show();
                bacSis.clear();
                GetDataTKBacSi();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });;
        dialogXoa.show();
    }
    public  void SuaTK(int id, String ten,int phone,String diaChi, String chuyeKhoa,String kinhNghiem,String TK, String MK) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sua_tai_khoan);
        EditText edtTen = (EditText) dialog.findViewById(R.id.edtTenBacSi);
        EditText edtPhone = (EditText) dialog.findViewById(R.id.edtSDT);
        EditText edtDiachi = (EditText) dialog.findViewById(R.id.edtDiaChi);
        EditText edtChuyenKhoa = (EditText) dialog.findViewById(R.id.edtChuyenKhoa);
        EditText edtKinhNghiem = (EditText) dialog.findViewById(R.id.edtKinhNghiem);
        EditText edtTK = (EditText) dialog.findViewById(R.id.edtTenTK);
        EditText edtMK = (EditText) dialog.findViewById(R.id.edtMatKhau);
        Button mbtnCapNhat = (Button) dialog.findViewById(R.id.btnCapNhat);
        Button mbtnHuy = (Button) dialog.findViewById(R.id.btnHuy);

        edtTen.setText(ten);
        edtPhone.setText(String.valueOf(phone));
        edtDiachi.setText(diaChi);
        edtChuyenKhoa.setText(chuyeKhoa);
        edtKinhNghiem.setText(kinhNghiem);
        edtTK.setText(TK);
        edtMK.setText(MK);
        mbtnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String medtTenBacSiMoi = edtTen.getText().toString().trim();
                String medtSDTMoi = edtPhone.getText().toString().trim();
                String medtDiaChiMoi = edtDiachi.getText().toString().trim();
                String medtChuyenKhoaMoi = edtChuyenKhoa.getText().toString().trim();
                String medtKinhNghiemMoi = edtKinhNghiem.getText().toString().trim();
                String medtTKMoi = edtTK.getText().toString().trim();
                String medtMKMoi = edtMK.getText().toString().trim();
                //update database
                databaseTKBacSi.QueryData("UPDATE TKBacSi SET Ten='" + medtTenBacSiMoi + "',Phone='" + medtSDTMoi + "',DiaChi='" + medtDiaChiMoi + "'" +
                        ",ChuyenKhoa='" + medtChuyenKhoaMoi + "',KinhNghiem='" + medtKinhNghiemMoi + "',TaiKhoan='" + medtTKMoi + "',MatKhau='" + medtMKMoi + "' WHERE Id='" + id + "'");
                Toast.makeText(QuanLyTKBacSiActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                bacSis.clear();
                GetDataTKBacSi();
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