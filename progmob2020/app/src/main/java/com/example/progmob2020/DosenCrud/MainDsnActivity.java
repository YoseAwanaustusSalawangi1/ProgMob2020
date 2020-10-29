package com.example.progmob2020.DosenCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.progmob2020.Model.Dosen;
import com.example.progmob2020.R;

public class MainDsnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dsn);

        //Variable
        Button btnAddDsn = (Button)findViewById(R.id.buttonAddDsn);
        Button btnLihatDsn = (Button)findViewById(R.id.buttonLihatDsn);
        Button btnHapusDsn = (Button)findViewById(R.id.buttonHapusDsn);
        Button btnUpdateDsn = (Button)findViewById(R.id.buttonUpdateDsn);

        //Action
        btnLihatDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnAddDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });
        btnHapusDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, HapusDsnActivity.class);
                startActivity(intent);
            }
        });
        btnUpdateDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}