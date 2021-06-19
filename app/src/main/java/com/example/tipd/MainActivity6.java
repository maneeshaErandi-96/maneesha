package com.example.tipd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText username,password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        username=(EditText)findViewById(R.id.edit_user);
        password=(EditText)findViewById(R.id.edit_password);
        login=(Button)findViewById(R.id.button5);
        DB=new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity6.this, "please enter the all the fields",Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkuserpass=DB.checkUserNamePassword(user,pass);
                    if(checkuserpass== true){
                        Toast.makeText(MainActivity6.this, "Sign in Successfull",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),AddDetails.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(MainActivity6.this, "Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}