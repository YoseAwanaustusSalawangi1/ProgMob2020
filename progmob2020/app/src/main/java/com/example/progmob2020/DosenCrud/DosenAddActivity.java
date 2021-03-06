package com.example.progmob2020.DosenCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenAddActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        //Variable
        EditText edNama = (EditText)findViewById(R.id.editTextNamaDsn);
        EditText edNidn = (EditText)findViewById(R.id.editTextNidn);
        EditText edAlamat = (EditText)findViewById(R.id.editTextAlamatDsn);
        EditText edEmail = (EditText)findViewById(R.id.editTextEmailDsn);
        EditText edGelar = (EditText)findViewById(R.id.editTextGelar);
        Button btnSimpanDsn = (Button)findViewById(R.id.buttonSimpanDsn);
        pd = new ProgressDialog(DosenAddActivity.this);

        //Action
        btnSimpanDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dsn(
                        edNama.getText().toString(),
                        edNidn.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "Kososongkan saja",
                        "72180217"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DosenAddActivity.this, DosenGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Gagal Ditambhakan", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}