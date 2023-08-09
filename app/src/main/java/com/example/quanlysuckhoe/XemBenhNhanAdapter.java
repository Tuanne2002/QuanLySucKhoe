package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class XemBenhNhanAdapter extends BaseAdapter {

    private XemHoSoBenhActivity context;
    private  int layout;
    private List<BenhNhan> benhNhans ;

    public XemBenhNhanAdapter(XemHoSoBenhActivity context, int layout, List<BenhNhan> benhNhans) {
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
        Button imgXem,imgDelete,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        XemBenhNhanAdapter.ViewHolder holder;
        if(view==null){
            holder=new XemBenhNhanAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtmaBenhNhan=(TextView) view.findViewById(R.id.txtMaBenhNhan);
            holder.txtTenBenhNhan=(TextView)  view.findViewById(R.id.txtTenBenhNhan);
            holder.imgXem = (Button) view.findViewById(R.id.imgXem);
            view.setTag(holder);
        }else {
            holder=(XemBenhNhanAdapter.ViewHolder) view.getTag();
        }

        BenhNhan benhNhan=benhNhans.get(i);
        holder.txtmaBenhNhan.setText(String.valueOf(benhNhan.getMaBenhNhan()));
        holder.txtTenBenhNhan.setText(benhNhan.getTenBenhNhan());

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
