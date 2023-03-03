package com.longkun.myapp4.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.longkun.myapp4.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends AppCompatActivity {

    private String username;

    private String password;

    private String sex;

    private String birthday;

    private String isInstantChecked;

    private Button registerButton;

    private String LOG_TAG = "LOG_TAG_REGISTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner sexSpinner = this.findViewById(R.id.register_sex);
        sexSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] sexArray = getResources().getStringArray(R.array.sex_list);
                sex = sexArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        DatePicker birthdayPicker = this.findViewById(R.id.register_birthday);
        birthdayPicker.setOnDateChangedListener((datePicker, i, i1, i2) -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i1, i2);
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthday = dateFormat.format(calendar.getTime());
        });

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch instantSwitch = this.findViewById(R.id.register_instant);
        instantSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            isInstantChecked = b ? "YES" : "NO";
        });

        registerButton = this.findViewById(R.id.register_button);
        registerButton.setOnClickListener(view -> {
            EditText usernameText = this.findViewById(R.id.register_username);
            username = usernameText.getText().toString().trim();
            EditText passwordText = this.findViewById(R.id.register_password);
            password = passwordText.getText().toString().trim();

            Log.i(LOG_TAG, "register by username: " + username);
            Log.i(LOG_TAG, "register by password: " + password);
            Log.i(LOG_TAG, "register by sex: " + sex);
            Log.i(LOG_TAG, "register by birthday: " + birthday);
            Log.i(LOG_TAG, "register by instant: " + isInstantChecked);

            Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show();

            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    // 停顿1秒跳转
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            };
            timer.schedule(timerTask, 1500);
        });
    }
}
