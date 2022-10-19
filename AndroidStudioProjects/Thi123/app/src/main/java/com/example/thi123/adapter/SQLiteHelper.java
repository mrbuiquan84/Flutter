package com.example.thi123.adapter;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.thi123.model.MonAn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="B18DCCN489_quanlymonan";
    private static int DATABASE_VERSION=1;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE tbl_monan("+
                    "cl_idmon INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "cl_tenmon TEXT,"+
                    "cl_giamon INTEGER,"+
                    "cl_ngaydat TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    public void addMonAn(MonAn monAn){
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContentValues values = new ContentValues();
        values.put("cl_tenmon",monAn.getTenMon());
        values.put("cl_giamon",monAn.getGiaDat());
        values.put("cl_ngaydat",monAn.getNgayDat());
        db.insert("tbl_monan",null,values);
        Log.d("TAG", "addMonAn: ");
        db.close();
    }
    public List<MonAn> getallMon(){
        List<MonAn> list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        Cursor cursor=st.rawQuery("SELECT * FROM tbl_monan",null);
        while  (cursor!=null && cursor.moveToNext()){
                int ma = cursor.getInt(0);
                String ten = cursor.getString(1);
                Integer giadat = cursor.getInt(2);
                String thoigian = cursor.getString(3);
                list.add(new MonAn(ma, ten, giadat,thoigian));
                cursor.moveToNext();
            }

        st.close();
        return  list;
    }
}
