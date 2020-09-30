package com.example.progmob2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.progmob2020.pertemuan2.ListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable
        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);

        //Pertemuan 2
        Button btnList = (Button)findViewById(R.id.buttonListActivity);
        Button btnRecycler = (Button)findViewById(R.id.buttonRecyclerView);
        Button btnCard = (Button)findViewById(R.id.buttonCardView);

        //Action
        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Bisa Diklik",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                Bundle b = new Bundle();

                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);

                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void Tracker(View view) {
        Intent intent = new Intent(MainActivity.this, TrackerActivity.class);
        startActivity(intent);
    }
}