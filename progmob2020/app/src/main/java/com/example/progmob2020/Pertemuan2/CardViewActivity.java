package com.example.progmob2020.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.progmob2020.Adapter.MahasiswaCardAdapter;
import com.example.progmob2020.Adapter.MahasiswaRecyclerAdapter;
import com.example.progmob2020.Model.Mahasiswa;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rvCardView);
        MahasiswaCardAdapter mahasiswaCardAdapter;

        //Data Dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //Generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Joko","72180211", "082291854911");
        Mahasiswa m2 = new Mahasiswa("Aldo","72180202", "082292854912");
        Mahasiswa m3 = new Mahasiswa("Davin","72180203", "082293854913");
        Mahasiswa m4 = new Mahasiswa("Dito","72180204", "082294854914");
        Mahasiswa m5 = new Mahasiswa("Julio","72180205", "082295854915");
        Mahasiswa m6 = new Mahasiswa("Deden","72180206", "082296854916");
        Mahasiswa m7 = new Mahasiswa("Denny","72180207", "082297854917");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);
        mahasiswaList.add(m6);
        mahasiswaList.add(m7);

        mahasiswaCardAdapter = new MahasiswaCardAdapter(CardViewActivity.this);
        mahasiswaCardAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(CardViewActivity.this));
        rv.setAdapter(mahasiswaCardAdapter);
    }
}