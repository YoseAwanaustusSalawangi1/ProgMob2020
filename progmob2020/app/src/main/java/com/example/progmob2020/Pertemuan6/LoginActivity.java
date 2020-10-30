package com.example.progmob2020.Pertemuan6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.Model.User;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(LoginActivity.this, "Selamat Datang", Toast.LENGTH_SHORT).show();

        session = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
            return;
        }

        EditText nimnik = findViewById(R.id.nimnik);
        EditText password =  findViewById(R.id.password);
        Button btnlogin = findViewById(R.id.buttonLogin);
        pd = new ProgressDialog(LoginActivity.this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Sedang Diproses...");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<User>> call = service.login(
                        nimnik.getText().toString(),
                        password.getText().toString()
                );
                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        pd.dismiss();
                        users = response.body();
                        if(users.size()==0){
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                        }else{
                            User u = users.get(0);

                            SharedPreferences.Editor editor = session.edit();
                            editor.clear();
                            editor.putString("nimnik", u.getNimnik());
                            editor.putString("nama", u.getNama());
                            editor.apply();
                            finish();
                            Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                            startActivity(intent);
                        }
                    }
                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}