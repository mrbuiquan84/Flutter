package com.example.thi123.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thi123.R;
import com.example.thi123.adapter.RecyViewAdapter;
import com.example.thi123.adapter.SQLiteHelper;
import com.example.thi123.model.MonAn;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentMonan extends Fragment{
    private RecyclerView recyclerView;
    RecyViewAdapter adapter;
    private FloatingActionButton addmonbt;
    private Button btnXemDsMonAn;
    private SQLiteHelper db;
    private List<MonAn> monAnList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recymonan);
        addmonbt=view.findViewById(R.id.fabmonan);
        adapter=new RecyViewAdapter();
        db=new SQLiteHelper(getContext());
        btnXemDsMonAn = view.findViewById(R.id.btnXemDsMonAn);
        addmonbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
                View alertView = layoutInflater.inflate(R.layout.dialog_them_mon_an,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setView(alertView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                EditText edtTenMonAn = alertView.findViewById(R.id.edtTenMonAn);
                EditText edtGiaMonAn = alertView.findViewById(R.id.edtGiaMonAn);
                EditText edtNgayMonAn = alertView.findViewById(R.id.edtNgayMonAn);
                Button btnLuuThemMonAn = alertView.findViewById(R.id.btnLuuThemMonAn);
                btnLuuThemMonAn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MonAn monAn = new MonAn(edtTenMonAn.getText().toString(),
                                Float.parseFloat(edtGiaMonAn.getText().toString()),
                                edtNgayMonAn.getText().toString());
                        db.addMonAn(monAn);
                        alertDialog.dismiss();
                    }
                });
            }
        });




        monAnList.add(new MonAn(1,"Anhquuan",1,"12121"));

        btnXemDsMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MonAn> monAnList = db.getallMon();
                adapter.setList(monAnList);
                LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        monAnList = db.getallMon();
        adapter.setList(monAnList);
    }
}
