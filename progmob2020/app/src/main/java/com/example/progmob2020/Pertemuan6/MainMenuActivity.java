package com.example.progmob2020.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.progmob2020.MahasiswaCrud.MainMhsActivity;
import com.example.progmob2020.DosenCrud.MainDsnActivity;
import com.example.progmob2020.MatkulCrud.MainMatkulActivity;
import com.example.progmob2020.Model.User;
import com.example.progmob2020.R;

import java.util.List;

public class MainMenuActivity extends AppCompatActivity {
    Toolbar tbLogout;
    SharedPreferences session;
    ProgressDialog pd;
    List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toast.makeText(MainMenuActivity.this, "Silahkan Di Pilih", Toast.LENGTH_SHORT).show();
        session = PreferenceManager.getDefaultSharedPreferences(MainMenuActivity.this);

        if(session.getString("nimnik", "").isEmpty() && session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
            return;
        }
        //Variable
        ImageView btnDataDsn = (ImageView) findViewById(R.id.imageViewDataDsn);
        ImageView btnDataMhs = (ImageView) findViewById(R.id.imageViewMhs);
        ImageView btnDataMatkul = (ImageView) findViewById(R.id.imageViewMatkul);
        ImageView btnLogout = (ImageView) findViewById(R.id.imageViewLogout);

        //Action
        btnDataDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainMenuActivity.this, MainDsnActivity.class);
                startActivity(inten);
            }
        });
        btnDataMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainMenuActivity.this, MainMhsActivity.class);
                startActivity(inten);
            }
        });
        btnDataMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainMenuActivity.this, MainMatkulActivity.class);
                startActivity(inten);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = session.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent Intent = new Intent(MainMenuActivity.this,LoginActivity.class);
                startActivity(Intent);
            }
        });
    }
}
