package com.example.progmob2020.MatkulCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.DosenCrud.DosenAddActivity;
import com.example.progmob2020.DosenCrud.DosenGetAllActivity;
import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulAddActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add);

        EditText edNama = (EditText)findViewById(R.id.editTextNamaMatkul);
        EditText edKode = (EditText)findViewById(R.id.editTextKodeMatkul);
        EditText edHari = (EditText)findViewById(R.id.editTextHari);
        EditText edSesi = (EditText)findViewById(R.id.editTextSesi);
        EditText edSks = (EditText)findViewById(R.id.editTextSks);
        Button btnSimpanMtkl = (Button)findViewById(R.id.buttonSimpanMatkul);
        pd = new ProgressDialog(MatkulAddActivity.this);

        btnSimpanMtkl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mtkl(
                        edNama.getText().toString(),
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSesi.getText().toString(),
                        edSks.getText().toString(),
                        "72180217"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MatkulAddActivity.this, MatkulGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "Data Gagal Ditambhakan", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}