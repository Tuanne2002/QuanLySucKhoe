package com.example.quanlysuckhoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TKBacSiAdapter extends BaseAdapter {
    private QuanLyTKBacSiActivity context;
    private  int layout;
    private List<BacSi> bacSis ;

    public TKBacSiAdapter(QuanLyTKBacSiActivity context, int layout, List<BacSi> bacSis) {
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
        TextView txtTKBacSi,txtHoVaTen;
        View imgXem,imgDelete,imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TKBacSiAdapter.ViewHolder holder;
        if(view==null){
            holder=new TKBacSiAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtTKBacSi=(TextView) view.findViewById(R.id.txtTKBacSi);
            holder.txtHoVaTen=(TextView)  view.findViewById(R.id.txtHoVaTen);
            holder.imgDelete=(View) view.findViewById(R.id.imgXoa);
            holder.imgEdit=(View) view.findViewById(R.id.imgEdit);
            holder.imgXem=(View) view.findViewById(R.id.imgXem);
            view.setTag(holder);
        }else {
            holder=(TKBacSiAdapter.ViewHolder) view.getTag();
        }

        BacSi bacSi=bacSis.get(i);
        holder.txtTKBacSi.setText(bacSi.getTaiKhoan());
        holder.txtHoVaTen.setText(bacSi.getTenBacSi());


        //sửa và xóa
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.SuaTK(
                        bacSi.getId(),
                        bacSi.getTenBacSi(),
                        bacSi.getSoDienThoai(),
                        bacSi.getDiaChi(),
                        bacSi.getChuyenKhoa(),
                        bacSi.getKinhNghiem(),
                        bacSi.getTaiKhoan(),
                        bacSi.getMatKhau()
                );
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaTKBacSi(
                        bacSi.getId(),
                        bacSi.getTenBacSi()
                );
            }
        });

        return view;

    }

}
