package com.landayan.landayan_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btn_save, btn_display;
    TextView tv_output;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_display = (Button) findViewById(R.id.btn_display);
        tv_output = (TextView) findViewById(R.id.tv_output);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",et_username.getText().toString());
        editor.putString("pwd", et_password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view){
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd","");

        tv_output.setText("User is " + user + " and the password is " + password);
    }
}
