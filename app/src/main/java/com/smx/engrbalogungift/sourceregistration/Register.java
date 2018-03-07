package com.smx.engrbalogungift.sourceregistration;

import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText et_fullname, et_email, et_username, et_password;
    private String fullname, email, username, password;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_fullname = (EditText) findViewById(R.id.fullname);
        et_email = (EditText) findViewById(R.id.email);
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                register();
            }
        });
    }
    public void register() {
        initialize();
        if (!validate()) {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT);

        }
        else {
            onSignupSuccess();
        }

    }

    private void onSignupSuccess() {
    }

    private boolean validate() {
        boolean valid = true;
        if (fullname.isEmpty() || fullname.length()>32){
            et_fullname.setError("Enter A Valid Name");
            valid = false;
        }

        if (email.isEmpty() || email.length()>32){
            et_email.setError("Enter A Valid Name");
            valid = false;
        }

        if (username.isEmpty() || username.length()>32){
            et_username.setError("Enter A Valid Name");
            valid = false;
        }

        if (password.isEmpty() || password.length()>32){
            et_password.setError("Enter A Valid Name");
            valid = false;
        }

        return valid;
    }

    public void initialize() {
        fullname = et_fullname.getText().toString().trim();
        email = et_email.getText().toString().trim();
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
    }
}
