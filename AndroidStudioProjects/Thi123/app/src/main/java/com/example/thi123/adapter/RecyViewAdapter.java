package com.example.thi123.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thi123.R;
import com.example.thi123.model.MonAn;

import java.util.ArrayList;
import java.util.List;

public class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.HomeViewHolder> {
    private List<MonAn> list;

    public RecyViewAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<MonAn> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public MonAn getList(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        MonAn monan= list.get(position);
        holder.idmon.setText(monan.getMaMon());
        holder.tenmon.setText(monan.getTenMon());
        holder.giadat.setText(String.valueOf(monan.getGiaDat()));
        holder.thoigian.setText(monan.getNgayDat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView idmon,tenmon,giadat,thoigian;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            idmon=view.findViewById(R.id.txtidMonanItem);
            tenmon=view.findViewById(R.id.txtTenMonAnItem);
            giadat=view.findViewById(R.id.txtGiaMonAnItem);
            thoigian=view.findViewById(R.id.txtNgayDatMonAnItem);
        }
    }
}
