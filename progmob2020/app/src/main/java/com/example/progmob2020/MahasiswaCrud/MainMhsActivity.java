package com.example.progmob2020.MahasiswaCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.example.progmob2020.Pertemuan6.MainMenuActivity;
import com.example.progmob2020.R;

public class MainMhsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        Button btnGet = (Button)findViewById(R.id.buttonGetMhs);
        Button btnAdd = (Button)findViewById(R.id.buttonAddMhs);
        Button btnUdt = (Button)findViewById(R.id.buttonUpdateMhs);
        Button btnDlt = (Button)findViewById(R.id.buttonDeleteMhs);
        ImageView btnKembali = (ImageView)findViewById(R.id.imageViewDataSia);

        //Action
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });
        btnUdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, HapusMhsActivity.class);
                startActivity(intent);
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}