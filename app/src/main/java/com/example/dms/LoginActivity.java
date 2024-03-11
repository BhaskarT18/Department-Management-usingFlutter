package com.example.dms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("tag", "login");
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        myDB= new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass= password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter the Credentials", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Boolean checkuserpass =  myDB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);



                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalide Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}