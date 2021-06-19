package com.example.tipd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.example.tipd.Adapter.SearchAdapter;
import com.example.tipd.Database.Database;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);



    }

    public void onClickbutton(View view) {
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }

    public void onClickbutton2(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }

    public void onClickImage(View view) {
        Intent in=new Intent(MainActivity.this,MainActivity4.class);
        startActivity(in);
    }


    public void Onlogin(View view) {
        Intent inte=new Intent(MainActivity.this,MainActivity6.class);
        startActivity(inte);
    }
}
