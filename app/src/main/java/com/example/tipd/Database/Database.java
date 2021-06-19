package com.example.tipd.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.tipd.Model.product;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME="hscode.db";
    private static final int DB_VER=1;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    //Function get all product

    public List<product> getProduct(){
        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"id","hsCode","hsDescription","unit","vat","CustomsDuty","Surcharge","pal","CessLevy","ExciseDuty","RIDL","SRL","NBT"};
        String tableName="hsproduct";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<product> result=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                product product=new product();
                product.setId(cursor.getInt(cursor.getColumnIndex("id")));
                product.setHsCode(cursor.getString(cursor.getColumnIndex("hsCode")));
                product.setHsDescription(cursor.getString(cursor.getColumnIndex("hsDescription")));
                product.setUnit(cursor.getString(cursor.getColumnIndex("unit")));
               product.setVat(cursor.getString(cursor.getColumnIndex("vat")));
               product.setCustomsDuty(cursor.getString(cursor.getColumnIndex("CustomsDuty")));
                product.setSurcharge(cursor.getString(cursor.getColumnIndex("Surcharge")));
                product.setPal(cursor.getString(cursor.getColumnIndex("pal")));
                product.setCessLevy(cursor.getString(cursor.getColumnIndex("CessLevy")));
                product.setExciseDuty(cursor.getString(cursor.getColumnIndex("ExciseDuty")));
                product.setRidl(cursor.getString(cursor.getColumnIndex("RIDL")));
                product.setSrl(cursor.getString(cursor.getColumnIndex("SRL")));
                product.setNbt(cursor.getString(cursor.getColumnIndex("NBT")));

                result.add(product);
            }while (cursor.moveToNext());

        }
        return result;
    }

    //function get all product name

    public  List<String> getHsDescription(){
        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"hsDescription"};
        String tableName="hsproduct";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {

                result.add(cursor.getString(cursor.getColumnIndex("hsDescription")));
            }while (cursor.moveToNext());

        }
        return result;

    }

    //function ge product by hsCode

    public List<product> getProductByhsDescription(String hsDescription){
        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"id","hsCode","hsDescription","unit","vat","CustomsDuty","Surcharge","pal","CessLevy","ExciseDuty","RIDL","SRL","NBT"};
        String tableName="hsproduct";

        qb.setTables(tableName);
        //This will like query:select * from hsproduct where hsDescription LIKE %pattern%

        Cursor cursor=qb.query(db,sqlSelect,"hsDescription LIKE ?",new String[]{"%"+hsDescription+"%"},null,null,null);
        List<product> result=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                product product=new product();
                product.setId(cursor.getInt(cursor.getColumnIndex("id")));
                product.setHsCode(cursor.getString(cursor.getColumnIndex("hsCode")));
                product.setHsDescription(cursor.getString(cursor.getColumnIndex("hsDescription")));
                product.setUnit(cursor.getString(cursor.getColumnIndex("unit")));
                product.setVat(cursor.getString(cursor.getColumnIndex("vat")));
                product.setCustomsDuty(cursor.getString(cursor.getColumnIndex("CustomsDuty")));
                product.setSurcharge(cursor.getString(cursor.getColumnIndex("Surcharge")));
                product.setPal(cursor.getString(cursor.getColumnIndex("pal")));
                product.setCessLevy(cursor.getString(cursor.getColumnIndex("CessLevy")));
                product.setExciseDuty(cursor.getString(cursor.getColumnIndex("ExciseDuty")));
                product.setRidl(cursor.getString(cursor.getColumnIndex("RIDL")));
                product.setSrl(cursor.getString(cursor.getColumnIndex("SRL")));
                product.setNbt(cursor.getString(cursor.getColumnIndex("NBT")));


                result.add(product);
            }while (cursor.moveToNext());

        }
        return result;
    }
}
