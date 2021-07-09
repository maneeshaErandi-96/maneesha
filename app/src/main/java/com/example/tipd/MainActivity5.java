package com.example.tipd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tipd.Model.product;

public class MainActivity5 extends AppCompatActivity {

    String  hsDes,hsvat,hsunit, hscustoms, hsSurcharge,hspal, hscess, hsExcise,hsridl,hsSrl,hsnbt,hscode;
    TextView des,un,va,customs,sur,ces,ex,RIDL,SRL,NBT,pa,resultNew,hsc;
    EditText cif_txt;
    Button button2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);




        hsDes = getIntent().getStringExtra("hsDescription");
         hsvat = getIntent().getStringExtra("vat");
         hsunit = getIntent().getStringExtra("unit");
         hscustoms=getIntent().getStringExtra("customsDuty");
         hsSurcharge=getIntent().getStringExtra("surcharge");
       hspal=getIntent().getStringExtra("pal");
         hscess=getIntent().getStringExtra("cessLevy");
         hsExcise=getIntent().getStringExtra("exciseDuty");
         hsridl=getIntent().getStringExtra("ridl");
        hsSrl=getIntent().getStringExtra("srl");
         hsnbt=getIntent().getStringExtra("nbt");
        hscode=getIntent().getStringExtra("hsCode");



        des = (TextView) findViewById(R.id.des);
         un = (TextView) findViewById(R.id.un);
          va = (TextView) findViewById(R.id.va);
         customs=(TextView)findViewById(R.id.customs) ;
         sur=(TextView)findViewById(R.id.sur) ;
         ces=(TextView)findViewById(R.id.ces) ;
         ex=(TextView)findViewById(R.id.ex) ;
         RIDL=(TextView)findViewById(R.id.RIDL) ;
         SRL=(TextView)findViewById(R.id.SRL) ;
        NBT=(TextView)findViewById(R.id.NBT) ;
         pa=(TextView)findViewById(R.id.pa) ;
        hsc = (TextView) findViewById(R.id.hsc);

         resultNew=(TextView)findViewById(R.id.resultNew);
         cif_txt=(EditText)findViewById(R.id.cif_txt);
         button2=(Button)findViewById(R.id.button2);


        des.setText(hsDes);
        un.setText(hsunit);
        va.setText(hsvat);
        customs.setText(hscustoms);
        sur.setText(hsSurcharge);
        ex.setText(hsExcise);
       RIDL.setText(hsridl);
        SRL.setText(hsSrl);
        NBT.setText(hsnbt);
        pa.setText(hspal);
        ces.setText(hscess);
        hsc.setText(hscode);




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double palnew=Double.parseDouble(pa.getText().toString());
                Double cifnew=Double.parseDouble(cif_txt.getText().toString());
                Double resultNew1=palnew * cifnew /100;

                Double vatnew=Double.parseDouble(va.getText().toString());
                Double resultNew2=vatnew * cifnew /100;

                Double customsNew=Double.parseDouble(customs.getText().toString());
                Double resultNew3=customsNew * cifnew /100;

                Double surNew=Double.parseDouble(sur.getText().toString());
                Double resultNew4=surNew * cifnew /100;

                Double cesNew=Double.parseDouble(ces.getText().toString());
                Double resultNew5=cesNew * cifnew /100;

                Double exNew=Double.parseDouble(ex.getText().toString());
                Double resultNew6=exNew * cifnew /100;

                Double ridlNew=Double.parseDouble(RIDL.getText().toString());
                Double resultNew7=ridlNew * cifnew /100;

                Double srlNew=Double.parseDouble(SRL.getText().toString());
                Double resultNew8=srlNew * cifnew /100;

                Double nbtNew=Double.parseDouble(va.getText().toString());
                Double resultNew9=nbtNew * cifnew /100;

                Double ResultAllNew=resultNew1+resultNew2+resultNew3+resultNew4+resultNew5+resultNew6+resultNew7+resultNew8+resultNew9;




                resultNew.setText(Double.toString(ResultAllNew));
            }
        });





    }



}
