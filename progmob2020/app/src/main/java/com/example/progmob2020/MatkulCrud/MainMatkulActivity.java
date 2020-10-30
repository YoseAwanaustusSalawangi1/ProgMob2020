package com.example.progmob2020.MatkulCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.progmob2020.DosenCrud.DosenGetAllActivity;
import com.example.progmob2020.DosenCrud.DosenUpdateActivity;
import com.example.progmob2020.DosenCrud.MainDsnActivity;
import com.example.progmob2020.Pertemuan6.MainMenuActivity;
import com.example.progmob2020.R;

public class MainMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);
        //Variable
        Button btnLihatMatkul = (Button)findViewById(R.id.buttonLihatMatkul);
        Button btnTambahhMatkul = (Button)findViewById(R.id.buttonTambahMatkul);
        Button btnHapusMatkul = (Button)findViewById(R.id.buttonHapusMatkul);
        ImageView btnKembali = (ImageView)findViewById(R.id.imageViewDataAkademik);

        //Action
        btnLihatMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnTambahhMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulAddActivity.class);
                startActivity(intent);
            }
        });
        btnHapusMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, HapusMatkulActivity.class);
                startActivity(intent);
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}