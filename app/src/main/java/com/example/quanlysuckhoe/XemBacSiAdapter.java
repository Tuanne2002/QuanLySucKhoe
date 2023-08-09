package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class XemBacSiAdapter extends BaseAdapter {
    private XemDsBacSiActivity context;
    private  int layout;
    private List<BacSi> bacSis ;

    public XemBacSiAdapter(XemDsBacSiActivity context, int layout, List<BacSi> bacSis) {
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
        View imgxemthongtin,imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        XemBacSiAdapter.ViewHolder holder;
        if(view==null){
            holder=new XemBacSiAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtMaBacSi=(TextView) view.findViewById(R.id.txtMaBacSi);
            holder.txtTenBacSi=(TextView)  view.findViewById(R.id.txtTenBacSi);
            holder.txtChuyenKhoa=(TextView)  view.findViewById(R.id.txtChuyenKhoa);
            holder.imgDelete=(View) view.findViewById(R.id.auto_delete);
            holder.imgxemthongtin=(View) view.findViewById(R.id.imgXem);
            view.setTag(holder);
        }else {
            holder=(XemBacSiAdapter.ViewHolder) view.getTag();
        }

        BacSi bacSi=bacSis.get(i);
        holder.txtMaBacSi.setText(String.valueOf(bacSi.getMaBacSi()));
        holder.txtTenBacSi.setText(bacSi.getTenBacSi());
        holder.txtChuyenKhoa.setText(bacSi.getChuyenKhoa());

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
