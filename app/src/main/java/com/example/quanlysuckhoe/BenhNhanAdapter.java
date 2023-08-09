package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class BenhNhanAdapter extends BaseAdapter {

    private HoSoBenhNhanActivity context;
    private  int layout;
    private List<BenhNhan> benhNhans ;

    public BenhNhanAdapter(HoSoBenhNhanActivity context, int layout, List<BenhNhan> benhNhans) {
        this.context = context;
        this.layout = layout;
        this.benhNhans = benhNhans;
    }

    @Override
    public int getCount() {
        return benhNhans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    private class ViewHolder{
        TextView txtmaBenhNhan,txtTenBenhNhan;
        Button  imgXem,imgDelete,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtmaBenhNhan=(TextView) view.findViewById(R.id.txtMaBenhNhan);
            holder.txtTenBenhNhan=(TextView)  view.findViewById(R.id.txtTenBenhNhan);
            holder.imgDelete = (Button)view.findViewById(R.id.auto_delete);
            holder.imgXem = (Button) view.findViewById(R.id.imgXem);
            holder.imgEdit = (Button) view.findViewById(R.id.xemchitiet);
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }

        BenhNhan benhNhan=benhNhans.get(i);
        holder.txtmaBenhNhan.setText(String.valueOf(benhNhan.getMaBenhNhan()));
        holder.txtTenBenhNhan.setText(benhNhan.getTenBenhNhan());


        //sửa và xóa
            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    context.SuaThongTin(
                            benhNhan.getId(),
                            benhNhan.getMaBenhNhan(),
                            benhNhan.getTenBenhNhan(),
                            benhNhan.getGioiTinh(),
                            benhNhan.getDiaChi(),
                            benhNhan.getPhone(),
                            benhNhan.getBenhAn()

                    );
                }
            });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaBenhNhan(
                        benhNhan.getId(),
                        benhNhan.getTenBenhNhan()
                );
            }
        });
        holder.imgXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.XemChiTiet(
                        benhNhan.getMaBenhNhan(),
                        benhNhan.getTenBenhNhan(),
                        benhNhan.getGioiTinh(),
                        benhNhan.getDiaChi(),
                        benhNhan.getPhone(),
                        benhNhan.getBenhAn()
                );
            }
        });
        return view;
    }
}
