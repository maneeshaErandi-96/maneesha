package com.example.tipd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity {
    Button add,update,delete;
    EditText viewid,view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11,view12;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        add=(Button)findViewById(R.id.add);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        viewid=(EditText)findViewById(R.id.viewid);
        view1=(EditText)findViewById(R.id.view1);
        view2=(EditText)findViewById(R.id.view2);
        view3=(EditText)findViewById(R.id.view3);
        view4=(EditText)findViewById(R.id.view4);
        view5=(EditText)findViewById(R.id.view5);
        view6=(EditText)findViewById(R.id.view6);
        view7=(EditText)findViewById(R.id.view7);
        view8=(EditText)findViewById(R.id.view8);
        view9=(EditText)findViewById(R.id.view9);
        view10=(EditText)findViewById(R.id.view10);
        view11=(EditText)findViewById(R.id.view11);
        view12=(EditText)findViewById(R.id.view12);
        openHelper=new DBHelper(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hsCode=view1.getText().toString();
                String hsDescription=view2.getText().toString();
                String unit=view3.getText().toString();
                String pal=view4.getText().toString();
                String vat=view5.getText().toString();
                String RIDL=view6.getText().toString();
                String SRL=view7.getText().toString();
                String NBT=view8.getText().toString();
                String Surcharge=view9.getText().toString();
                String CessLevy=view10.getText().toString();
                String CustomsDuty=view11.getText().toString();
                String ExciseDuty=view12.getText().toString();
                MyDB=openHelper.getWritableDatabase();
                InsertData(hsCode,hsDescription,unit,pal,vat,RIDL,SRL,NBT,Surcharge,CessLevy,CustomsDuty,ExciseDuty);
                Toast.makeText(getApplicationContext(),"INSERT SUCCESSFULLY",Toast.LENGTH_LONG).show();



            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDB=openHelper.getWritableDatabase();
                String id=viewid.getText().toString();
                deleteData(id);
                Toast.makeText(getApplicationContext(),"DELETE SUCCESSFULLY",Toast.LENGTH_LONG).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hsCode=view1.getText().toString();
                String hsDescription=view2.getText().toString();
                String unit=view3.getText().toString();
                String pal=view4.getText().toString();
                String vat=view5.getText().toString();
                String RIDL=view6.getText().toString();
                String SRL=view7.getText().toString();
                String NBT=view8.getText().toString();
                String Surcharge=view9.getText().toString();
                String CessLevy=view10.getText().toString();
                String CustomsDuty=view11.getText().toString();
                String ExciseDuty=view12.getText().toString();
                MyDB=openHelper.getWritableDatabase();
                updateData(hsCode,hsDescription,unit,pal,vat,RIDL,SRL,NBT,Surcharge,CessLevy,CustomsDuty,ExciseDuty);
                Toast.makeText(getApplicationContext(),"UPDATE SUCCESSFULLY",Toast.LENGTH_LONG).show();
            }
        });


    }

    public void InsertData(String hsCode,  String hsDescription,String unit, String pal,String vat,String RIDL, String SRL,String NBT, String Surcharge, String CessLevy,String CustomsDuty, String ExciseDuty){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.col_1,hsCode);
        contentValues.put(DBHelper.col_2,hsDescription);
        contentValues.put(DBHelper.col_3,unit);
        contentValues.put(DBHelper.col_4,vat);
        contentValues.put(DBHelper.col_5,CustomsDuty);
        contentValues.put(DBHelper.col_6,Surcharge);
        contentValues.put(DBHelper.col_7,pal);
        contentValues.put(DBHelper.col_8,ExciseDuty);
        contentValues.put(DBHelper.col_9,RIDL);
        contentValues.put(DBHelper.col_10,CessLevy);
        contentValues.put(DBHelper.col_11,SRL);
        contentValues.put(DBHelper.col_12,NBT);
        long id=MyDB.insert(DBHelper.TABLENAME,null,contentValues);
    }
    public boolean deleteData(String id){
        return  MyDB.delete(DBHelper.TABLENAME, DBHelper.col_13 + "=?",new String[] {id})>0;

    }
    public  boolean updateData(String hsCode,  String hsDescription,String unit, String pal,String vat,String RIDL, String SRL,String NBT, String Surcharge, String CessLevy,String CustomsDuty, String ExciseDuty){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.col_1,hsCode);
        contentValues.put(DBHelper.col_2,hsDescription);
        contentValues.put(DBHelper.col_3,unit);
        contentValues.put(DBHelper.col_4,vat);
        contentValues.put(DBHelper.col_5,CustomsDuty);
        contentValues.put(DBHelper.col_6,Surcharge);
        contentValues.put(DBHelper.col_7,pal);
        contentValues.put(DBHelper.col_8,ExciseDuty);
        contentValues.put(DBHelper.col_9,RIDL);
        contentValues.put(DBHelper.col_10,CessLevy);
        contentValues.put(DBHelper.col_11,SRL);
        contentValues.put(DBHelper.col_12,NBT);
        String id=viewid.getText().toString();
        return  MyDB.update(DBHelper.TABLENAME,contentValues,DBHelper.col_13+ "=?",new String[] {id})>0;
    }
}