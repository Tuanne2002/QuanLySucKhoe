package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LichSuBenhAdapter extends BaseAdapter {

    private LichSuBenhAnActivity context;
    private  int layout;
    private List<LichSuBenh> lichSuBenhs ;

    public LichSuBenhAdapter(LichSuBenhAnActivity context, int layout, List<LichSuBenh> lichSuBenhs) {
        this.context = context;
        this.layout = layout;
        this.lichSuBenhs = lichSuBenhs;
    }

    @Override
    public int getCount() {return lichSuBenhs.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}

    private class ViewHolder{
        TextView tvTenBenh, tvNguyenNhan, tvtime;
        View  imgxemthongtin,imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LichSuBenhAdapter.ViewHolder holder;
        if(view==null){
            holder=new LichSuBenhAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.tvTenBenh=(TextView) view.findViewById(R.id.tvtenbenh);
            holder.tvNguyenNhan=(TextView)  view.findViewById(R.id.nguyennhan);
            holder.tvtime=(TextView)  view.findViewById(R.id.ngay);
            //holder.imgDelete=(View) view.findViewById(R.id.auto_delete);//
            view.setTag(holder);
        }else {
            holder=(LichSuBenhAdapter.ViewHolder) view.getTag();
        }
        LichSuBenh lichSuBenh=lichSuBenhs.get(i);
        holder.tvTenBenh.setText(lichSuBenh.getTenBenh());
        holder.tvNguyenNhan.setText(lichSuBenh.getLyDo());
        holder.tvtime.setText(lichSuBenh.getTime());

        return view;
    }

}
