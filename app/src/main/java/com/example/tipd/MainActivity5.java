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






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);




        String hsDes = getIntent().getStringExtra("hsDescription");
        String hsvat = getIntent().getStringExtra("vat");
        String hsunit = getIntent().getStringExtra("unit");
        String hscustoms=getIntent().getStringExtra("customsDuty");
        String hsSurcharge=getIntent().getStringExtra("surcharge");
       String hspal=getIntent().getStringExtra("pal");
        String hscess=getIntent().getStringExtra("cessLevy");
        String hsExcise=getIntent().getStringExtra("exciseDuty");
        String hsridl=getIntent().getStringExtra("ridl");
       String hsSrl=getIntent().getStringExtra("srl");
        String hsnbt=getIntent().getStringExtra("nbt");


        TextView des = (TextView) findViewById(R.id.des);
        TextView un = (TextView) findViewById(R.id.un);
         TextView va = (TextView) findViewById(R.id.va);
        TextView customs=(TextView)findViewById(R.id.customs) ;
        TextView sur=(TextView)findViewById(R.id.sur) ;
        TextView ces=(TextView)findViewById(R.id.ces) ;
        TextView ex=(TextView)findViewById(R.id.ex) ;
        TextView RIDL=(TextView)findViewById(R.id.RIDL) ;
        TextView SRL=(TextView)findViewById(R.id.SRL) ;
        TextView NBT=(TextView)findViewById(R.id.NBT) ;
        TextView pa=(TextView)findViewById(R.id.pa) ;


        des.setText("hsDescription"+":"+" "+hsDes);
        un.setText("Unit"+":"+" "+hsunit);
        va.setText("Vat"+":"+" "+hsvat);
        customs.setText("Customs Duty"+":"+" "+hscustoms);
        sur.setText("Surcharge"+":"+" "+hsSurcharge);
        ex.setText("Excise Duty"+":"+" "+hsExcise);
       RIDL.setText("RIDL"+":"+" "+hsridl);
        SRL.setText("SRL"+":"+" "+hsSrl);
        NBT.setText("NBT"+":"+" "+hsnbt);
        pa.setText("pal"+":"+" "+hspal);
        ces.setText("Cess Levy"+":"+" "+hscess);










    }


    public void OnClickTarrif(View view) {
        Intent intent=new Intent(MainActivity5.this,MainActivity3.class);
        startActivity(intent);
    }
}
