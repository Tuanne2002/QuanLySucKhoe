package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TKNguoiDungAdapter extends BaseAdapter {
    private QuanLyTKNguoiDungActivity context;
    private  int layout;
    private List<BenhNhan> benhNhans ;

    public TKNguoiDungAdapter(QuanLyTKNguoiDungActivity context, int layout, List<BenhNhan> benhNhans) {
        this.context = context;
        this.layout = layout;
        this.benhNhans = benhNhans;
    }

    @Override
    public int getCount() {return benhNhans.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}
    private class ViewHolder{
        TextView txtTKNguoiDung,txtHoVaTen;
        View imgXem,imgDelete,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TKNguoiDungAdapter.ViewHolder holder;
        if(view==null){
            holder=new TKNguoiDungAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtTKNguoiDung=(TextView) view.findViewById(R.id.txtTKNguoiDung);
            holder.txtHoVaTen=(TextView)  view.findViewById(R.id.txtHoVaTen);
            holder.imgDelete=(View) view.findViewById(R.id.imgXoa);
            //holder.imgEdit=(View) view.findViewById(R.id.imgEdit);
            holder.imgXem=(View) view.findViewById(R.id.imgXem);
            view.setTag(holder);
        }else {
            holder=(TKNguoiDungAdapter.ViewHolder) view.getTag();
        }

        BenhNhan benhNhan=benhNhans.get(i);
        holder.txtTKNguoiDung.setText(benhNhan.getTaiKhoan());
        holder.txtHoVaTen.setText(benhNhan.getTenBenhNhan());


        //sửa và xóa
        holder.imgXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.XemChiTiet(
                        benhNhan.getTenBenhNhan(),
                        benhNhan.getNgaySinh(),
                        benhNhan.getGioiTinh(),
                        benhNhan.getPhone(),
                        benhNhan.getDiaChi(),
                        benhNhan.getTaiKhoan(),
                        benhNhan.getMatKhau()
                );
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaTKNguoiDung(
                        benhNhan.getId(),
                        benhNhan.getTenBenhNhan()
                );
            }
        });

        return view;

    }
}
