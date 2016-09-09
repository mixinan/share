package com.mixinan.share;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt;
    private Button btInsert;
    private Button btDelete;
    private EditText etName;
    private EditText etPassword;
    private EditText etAge;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("test.db",MODE_PRIVATE,null);

        bt = (Button) findViewById(R.id.bt);
        btInsert = (Button) findViewById(R.id.btInsert);
        btDelete = (Button) findViewById(R.id.btDelete);

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etAge = (EditText) findViewById(R.id.etAge);

        bt.setOnClickListener(this);
        btInsert.setOnClickListener(this);
        btDelete.setOnClickListener(this);
    }

    private void createTable() {
        String sql = "CREATE TABLE mixinan (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(16) UNIQUE NOT NULL, " +
                "age INTEGER, " +
                "password VARCHAR(20) NOT NULL" +
                ")";
        db.execSQL(sql);
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt:
                createTable();
                break;
            case R.id.btInsert:
                insertData();
                break;
        }

    }

    private void insertData() {
//        String name = etName.getText().toString();
//        int age = Integer.parseInt(etAge.getText().toString());
//        String password = etPassword.getText().toString();

        String sql = "insert into mixinan (name, age， password) values ('michael', 21， '123321')";
        db.execSQL(sql);
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
    }
}
