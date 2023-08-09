package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BacSiAdapter extends BaseAdapter {
    private BacSiTuVanActivity context;
    private  int layout;
    private List<BacSi> bacSis ;

    public BacSiAdapter(BacSiTuVanActivity context, int layout, List<BacSi> bacSis) {
        this.context = context;
        this.layout = layout;
        this.bacSis = bacSis;
    }

    @Override
    public int getCount() {return bacSis.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}
    private class ViewHolder{
        TextView txtMaBacSi,txtTenBacSi,txtChuyenKhoa;
        View  imgxemthongtin,imgDelete,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BacSiAdapter.ViewHolder holder;
        if(view==null){
            holder=new BacSiAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtMaBacSi=(TextView) view.findViewById(R.id.txtMaBacSi);
            holder.txtTenBacSi=(TextView)  view.findViewById(R.id.txtTenBacSi);
            holder.txtChuyenKhoa=(TextView)  view.findViewById(R.id.txtChuyenKhoa);
            holder.imgDelete=(View) view.findViewById(R.id.imgXoa);
            holder.imgEdit=(View) view.findViewById(R.id.imgEdit);
            holder.imgxemthongtin=(View) view.findViewById(R.id.imgXem);
            view.setTag(holder);
        }else {
            holder=(BacSiAdapter.ViewHolder) view.getTag();
        }

        BacSi bacSi=bacSis.get(i);
        holder.txtMaBacSi.setText(String.valueOf(bacSi.getMaBacSi()));
        holder.txtTenBacSi.setText(bacSi.getTenBacSi());
        holder.txtChuyenKhoa.setText(bacSi.getChuyenKhoa());

        //sửa và xóa
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.SuaBacSi(
                        bacSi.getId(),
                        bacSi.getMaBacSi(),
                        bacSi.getTenBacSi(),
                        bacSi.getChuyenKhoa(),
                        bacSi.getSoDienThoai(),
                        bacSi.getKinhNghiem()
                );
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaBacSi(
                        bacSi.getId(),
                        bacSi.getTenBacSi()
                );
            }
        });
        holder.imgxemthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.XemChiTiet(
                        //bacSi.getId(),
                        bacSi.getMaBacSi(),
                        bacSi.getTenBacSi(),
                        bacSi.getChuyenKhoa(),
                        bacSi.getSoDienThoai(),
                        bacSi.getKinhNghiem()
                );
            }
        });
        return view;

    }

}
