package com.example.progmob2020.Pertemuan6;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.progmob2020.R;

public class SplashActivity extends Activity {
    SharedPreferences session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Toast.makeText(SplashActivity.this, "", Toast.LENGTH_SHORT).show();

        /*session = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(SplashActivity.this, MainMenuActivity.class));
            return;
        }*/

        Thread thread = new Thread(){
            public void run() {
                try{
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}