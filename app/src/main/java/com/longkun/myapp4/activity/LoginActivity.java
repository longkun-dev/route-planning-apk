package com.longkun.myapp4.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.longkun.myapp4.R;

public class LoginActivity extends Activity {

    private String username;

    private String password;

    private Button loginButton;

    private Button registerButton;

    private String LOG_TAG = "LOG_TAG_LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = this.findViewById(R.id.login_button);
        registerButton = this.findViewById(R.id.register_button);

        loginButton.setOnClickListener(view -> {
            EditText usernameText = this.findViewById(R.id.login_username);
            username = usernameText.getText().toString().trim();
            EditText passwordText = this.findViewById(R.id.login_password);
            password = passwordText.getText().toString().trim();
            Log.i(LOG_TAG, "login by username: " + username);
            Log.i(LOG_TAG, "login by password: " + password);

            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        });

        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
