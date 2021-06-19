package com.example.tipd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity  implements  View.OnClickListener{

    EditText viewcode,viewpal,viewvat,viewridl,viewsrl,viewnbt,viewsurcharge,viewcess,viewcustoms,viewexcis,viewcif;
    SQLiteDatabase sqLiteDatabase;
    Button cal,search_bt;

    String hsCode,hsDescription,unit,vat,CustomsDuty,Surcharge,pal,CessLevy,ExciseDuty,RIDL,SRL,NBT,search;
    TextView txt_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sqLiteDatabase=openOrCreateDatabase("hscode.db",MODE_PRIVATE,null);

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hsproduct(id INTEGER PRIMARY KEY AUTOINCREMENT, hsCode TEXT,hsDescription TEXT, unit TEXT, vat TEXT,CustomsDuty TEXT,Surcharge TEXT,pal TEXT,CessLevy TEXT, ExciseDuty TEXT, RIDL TEXT,SRL TEXT,NBT TEXT)");


        viewcode=(EditText)findViewById(R.id.viewcode);
        viewpal=(EditText)findViewById(R.id.viewpal);
        viewvat=(EditText)findViewById(R.id.viewvat);
        viewridl=(EditText)findViewById(R.id.viewridl);
        viewsrl=(EditText)findViewById(R.id.viewsrl);
        viewnbt=(EditText)findViewById(R.id.viewnbt);
        viewsurcharge=(EditText)findViewById(R.id.viewsurcharge);
        viewcess=(EditText)findViewById(R.id.viewcess);
        viewcustoms=(EditText)findViewById(R.id.viewcustoms);
        viewexcis=(EditText)findViewById(R.id.viewexcis);
        viewcif=(EditText)findViewById(R.id.viewcif);
        cal=(Button)findViewById(R.id.cal);
       search_bt=(Button)findViewById(R.id.search_bt);
       search_bt.setOnClickListener(this);
       onCal();


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.search_bt){
            search=viewcode.getText().toString().trim();
                if(search.equals("")){
                    Toast.makeText(this,"Enter hsCode",Toast.LENGTH_SHORT).show();
                    return;
                }

            Cursor c =sqLiteDatabase.rawQuery("Select * From hsproduct where hsCode='" + search +"'",null);
                if(c.moveToFirst())
                {
                    viewvat.setText(c.getString(5));
                    viewcustoms.setText(c.getString(6));
                    viewsurcharge.setText(c.getString(7));
                    viewpal.setText(c.getString(8));
                    viewcess.setText(c.getString(9));
                    viewexcis.setText(c.getString(10));
                    viewexcis.setText(c.getString(11));
                    viewridl.setText(c.getString(12));
                    viewsrl.setText(c.getString(13));
                    viewnbt.setText(c.getString(14));

                }
                else{
                    Toast.makeText(this, "Data not found",Toast.LENGTH_SHORT).show();
                }
        }

    }

    private void onCal() {
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double palnum=Double.parseDouble(viewpal.getText().toString());
                Double cifnum=Double.parseDouble(viewcif.getText().toString());
                Double result1=palnum * cifnum /100 ;

                Double vatnum=Double.parseDouble(viewvat.getText().toString());
                Double result2=vatnum * cifnum / 100;

                Double ridlnum=Double.parseDouble(viewridl.getText().toString());
                Double result3=ridlnum * cifnum / 100;

                Double srlnum=Double.parseDouble(viewsrl.getText().toString());
                Double result4=srlnum * cifnum / 100;

                Double nbtnum=Double.parseDouble(viewnbt.getText().toString());
                Double result5=nbtnum * cifnum / 100;

                Double surchargenum=Double.parseDouble(viewsurcharge.getText().toString());
                Double result6=surchargenum * cifnum / 100;

                Double cessnum=Double.parseDouble(viewcess.getText().toString());
                Double result7=cessnum * cifnum / 100;

                Double customsnum=Double.parseDouble(viewcustoms.getText().toString());
                Double result8=customsnum * cifnum / 100;

                Double excisnum=Double.parseDouble(viewexcis.getText().toString());
                Double result9=excisnum * cifnum / 100;

               double resultAll=result1+result2+result3+result4+result5+result6+result7+result8+result9;

               txt_result.setText(Double.toString(resultAll));

            }
        });
    }







}