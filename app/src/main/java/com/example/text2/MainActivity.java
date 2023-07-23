package com.example.text2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//声明控件
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mBtnLogin = (Button) findViewById(R.id.btn_login);
//实现跳转
mBtnLogin.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {

        Intent intent = null;
        intent = new Intent(MainActivity.this, FunctionActivity.class);
        startActivity(intent);
    }
});
    }
}