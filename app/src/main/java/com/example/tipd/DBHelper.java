package com.example.tipd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.annotation.Target;

public class DBHelper extends SQLiteOpenHelper {
    public  static final String DBNAME="hscode.db";
    public  static final String TABLENAME="hsproduct";


    public  static final String col_1="hsCode";
    public  static final String col_2="hsDescription";
    public  static final String col_3="unit";
    public  static final String col_4="vat";
    public  static final String col_5="CustomsDuty";
    public  static final String col_6="Surcharge";
    public  static final String col_7="pal";
    public  static final String col_8="ExciseDuty";
    public  static final String col_9="RIDL";
    public  static final String col_10="CessLevy";
    public  static final String col_11="SRL";
    public  static final String col_12="NBT";
    public  static final String col_13="id";
    public DBHelper( Context context) {
        super(context, "hscode.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table login(UserName Text primary key, Password Text)");
        MyDB.execSQL("create Table " + TABLENAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, hsCode TEXT,hsDescription TEXT, unit TEXT, vat TEXT,CustomsDuty TEXT,Surcharge TEXT,pal TEXT,CessLevy TEXT, ExciseDuty TEXT, RIDL TEXT,SRL TEXT,NBT TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists login");
        MyDB.execSQL("drop Table if exists "+TABLENAME);
        onCreate(MyDB);
    }

    public  Boolean checkUserName(String UserName){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ?",new String[] {UserName});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUserNamePassword(String UserName,String Password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ? and Password= ?",new String[] {UserName,Password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;



    }
}
