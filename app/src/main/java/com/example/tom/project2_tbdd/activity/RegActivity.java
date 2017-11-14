package com.example.tom.project2_tbdd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tom.project2_tbdd.R;
import com.example.tom.project2_tbdd.dao.UserDAO;
import com.example.tom.project2_tbdd.model.User;
import com.example.tom.project2_tbdd.sqlLite.UserCreate;

import java.util.List;

public class RegActivity extends AppCompatActivity {


    Button btDn, btDk;
    EditText editUsername, editPass, editXNMK, editEmail;
    CheckBox checked;
    RadioButton radNa, radNu, radKhac;
    UserCreate uc;
    UserDAO userDAO;
    User u;
    RadioGroup groupGenre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDAO = new UserDAO(this);
        userDAO.open();

        setContentView(R.layout.activity_reg);
        editUsername = findViewById(R.id.editTextTK);
        editPass = findViewById(R.id.editTextMK);
        editXNMK = findViewById(R.id.editTextXNMK);
        editEmail = findViewById(R.id.editTextEmail);

        checked = findViewById(R.id.checked);

        radNa = findViewById(R.id.nam);
        radNu = findViewById(R.id.nu);
        radKhac = findViewById(R.id.khac);


        btDn = findViewById(R.id.btDN);
        btDk = findViewById(R.id.btDK);

        btDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> l = userDAO.getListUser();
                Toast.makeText(getApplicationContext(), l.size() + "", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        btDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editPass.getText().toString();
                String repass = editXNMK.getText().toString();
                String username = editUsername.getText().toString();
                String email = editEmail.getText().toString();
                long genre =-1;


                if (password.trim().equals("") || repass.trim().equals("") || username.trim().equals("") || email.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Bạn phải nhập các trường bắt buột!", Toast.LENGTH_LONG).show();

                } else {
                    if (repass.trim().equals(password)) {
                        if (checked.isChecked()) {
                            switch (R.id.groupGenre) {
                                case R.id.nam:
                                    genre = 1;
                                    break;
                                case R.id.nu:
                                    genre = 2;
                                    break;
                                case R.id.khac:
                                    genre = 0;
                                    break;
                            }
                            u = new User(username, password, email, genre);
                            boolean adduser = userDAO.addUser(u);

                            if (adduser) {
                                Toast.makeText(getApplicationContext(), "Tạo user Thành công!", Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Tạo user không Thành công!", Toast.LENGTH_LONG).show();
                            }
                        } else {

                            Toast.makeText(getApplicationContext(), "bạn phải chấp nhận điều khoản!", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Xác nhận mật khẩu sai!", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }


}
