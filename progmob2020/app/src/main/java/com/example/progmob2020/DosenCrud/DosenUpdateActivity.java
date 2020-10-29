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

public class DosenUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaDsnBaru);
        EditText edNidnBaru= (EditText)findViewById(R.id.editTextNidnBaru);
        EditText edAlamatBaru = (EditText)findViewById(R.id.editTextAlamatDsnBaru);
        EditText edEmailBaru = (EditText)findViewById(R.id.editTextEmailDsnBaru);
        EditText edGelarBaru = (EditText)findViewById(R.id.editTextGelarBaru);
        EditText edNidnLama = (EditText)findViewById(R.id.editTextNidnCari);
        Button btnUpdateDsn = (Button)findViewById(R.id.buttonUbahDsn);
        pd = new ProgressDialog(DosenUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNamaBaru.setText(data.getStringExtra("nama"));
            edNidnBaru.setText(data.getStringExtra("nidn"));
            edAlamatBaru.setText(data.getStringExtra("alamat"));
            edEmailBaru.setText(data.getStringExtra("email"));
            edGelarBaru.setText(data.getStringExtra("gelar"));
            edNidnLama.setText(data.getStringExtra("nidn"));
        }

        btnUpdateDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_dsn(
                        edNamaBaru.getText().toString(),
                        edNidnBaru.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmailBaru.getText().toString(),
                        edGelarBaru.getText().toString(),
                        "Kosongkan saja",
                        "72180217",
                        edNidnLama.getText().toString()
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DosenUpdateActivity.this, MainDsnActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "Data Tidak Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}