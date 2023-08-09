package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ThuocAdapter extends BaseAdapter {

    private DanhSachThuocActivity context;
    private  int layout;
    private List<Thuoc> thuocList;

    public ThuocAdapter(DanhSachThuocActivity context, int layout, List<Thuoc> thuocList) {
        this.context = context;
        this.layout = layout;
        this.thuocList = thuocList;
    }


    @Override
    public int getCount() {
        return thuocList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHoder{
        TextView txtTenThuoc, txtSoLuong, txtCongDung,txtNgayBD,txtNgayKT,txtTenBN,txtMaBN;
        View imgXoa,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ThuocAdapter.ViewHoder hoder;
        if(view == null){
            hoder = new ThuocAdapter.ViewHoder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            //hoder.txtMaBN=(TextView) view.findViewById(R.id.txtMaBN);
            hoder.txtTenBN=(TextView) view.findViewById(R.id.txtTenBN);
            hoder.txtTenThuoc=(TextView) view.findViewById(R.id.txtTenThuoc);
            hoder.txtSoLuong=(TextView)  view.findViewById(R.id.txtSoluong);
            hoder.txtCongDung=(TextView) view.findViewById(R.id.txtCD1);
            hoder.txtNgayBD=(TextView) view.findViewById(R.id.txtNgayBatDau);
            hoder.txtNgayKT=(TextView) view.findViewById(R.id.txtNgayKetThuc);
            hoder.imgEdit=(View) view.findViewById(R.id.imgEdit);
            hoder.imgXoa=(View) view.findViewById(R.id.imgXoa);
            view.setTag(hoder);
        }else {
            hoder=(ThuocAdapter.ViewHoder) view.getTag();
        }
        Thuoc thuoc = thuocList.get(i);
        //hoder.txtMaBN.setText(thuoc.getMaBenhNhan());
        hoder.txtTenBN.setText(thuoc.getTenBenhNhan());
        hoder.txtTenThuoc.setText(thuoc.getTenThuoc());
        hoder.txtSoLuong.setText(thuoc.getSoLuong());
        hoder.txtCongDung.setText(thuoc.getCongDung());
        hoder.txtNgayBD.setText(thuoc.getNgayBD());
        hoder.txtNgayKT.setText(thuoc.getNgayKT());


        //sửa và xóa
        hoder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.SuaThuoc(
                        thuoc.getId(),
                        thuoc.getTenBenhNhan(),
                        thuoc.getTenThuoc(),
                        thuoc.getSoLuong(),
                        thuoc.getCongDung(),
                        thuoc.getNgayBD(),
                        thuoc.getNgayKT()
                );
            }
        });
        hoder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaThuoc(
                        thuoc.getId()
                );
            }
        });
        return view;
    }
}
