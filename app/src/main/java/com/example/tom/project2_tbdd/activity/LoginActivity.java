package com.example.tom.project2_tbdd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tom.project2_tbdd.R;
import com.example.tom.project2_tbdd.dao.UserDAO;

public class LoginActivity extends AppCompatActivity {
    public static final boolean AUTO_LOGIN =false;
    Button btnlogin,btnreg;
    EditText editUsername,editPassword;
    CheckBox cbauto;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.buttonLogin);
        btnreg = findViewById(R.id.buttonReg);

        editUsername = findViewById(R.id.editUsername);
        editPassword =findViewById(R.id.editPass);

        cbauto = findViewById(R.id.checked);

        userDAO =new UserDAO(this);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userDAO.login(editUsername.getText().toString(),editPassword.getText().toString())){
                   Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(i);
                    finish();


                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect Username or password!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
