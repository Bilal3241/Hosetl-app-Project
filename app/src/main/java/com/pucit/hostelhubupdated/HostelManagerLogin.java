package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HostelManagerLogin extends AppCompatActivity {

    private Button loginBtn;
    private Button signUpBtn;
    private TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_manager_login);
        final EditText textinputusername = (EditText) findViewById(R.id.manager_login_username);
        final EditText textinputpassword = (EditText) findViewById(R.id.manager_login_password);

        signUpBtn = (Button) findViewById(R.id.btn_signup_ll_hostel_manager_login_activity);
        loginBtn = (Button) findViewById(R.id.btn_login_hostel_manager_login_activity);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = textinputusername.getText().toString();
                final String pass = textinputpassword.getText().toString();
                if (isValidusername(username) && isValidPassword(pass)) {
                    Intent i = new Intent(getApplicationContext(), HostelManagerHomeActivity.class);
                    startActivity(i);
                } else {
                    if (!isValidusername(username)) {
                        textinputusername.setError("Invalid username");
                    }


                    if (!isValidPassword(pass)) {
                        textinputpassword.setError("Invalid Password");
                    }
                }
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = getIntent().getExtras();
                String role = b.getString("Role");
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                intent.putExtra("Role",role);
                startActivity(intent);
            }
        });


        forgotPassword = findViewById(R.id.tv_forgot_password_hostel_manager_login);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HostelManagerLogin.this, Forget.class);
                startActivity(i);
            }
        });
    }
        private boolean isValidusername(String user) {
            if (! user.equals("")) {
                return true;
            }
            return false;
        }
        // validating password with retype password
        private boolean isValidPassword(String pass) {
            if (pass != null && pass.length() > 6) {
                return true;
            }
            return false;
        }



}
