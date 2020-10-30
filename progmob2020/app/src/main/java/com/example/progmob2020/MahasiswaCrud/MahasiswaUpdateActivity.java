package com.example.progmob2020.MahasiswaCrud;

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

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);
        //Variable
        EditText edNimLama= (EditText)findViewById(R.id.editTextNimLama);
        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaBaru);
        EditText edNimBaru = (EditText)findViewById(R.id.editTextNimBaru);
        EditText edAlamatBaru = (EditText)findViewById(R.id.editTextAlamatBaru);
        EditText edEmailBaru = (EditText)findViewById(R.id.editTextEmailBaru);
        Button btnUpdate = (Button)findViewById(R.id.buttonUbahDsn);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNamaBaru.setText(data.getStringExtra("nama"));
            edNimBaru.setText(data.getStringExtra("nim"));
            edNimLama.setText(data.getStringExtra("nim"));
            edAlamatBaru.setText(data.getStringExtra("alamat"));
            edEmailBaru.setText(data.getStringExtra("email"));
        }

        //Action
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        edNamaBaru.getText().toString(),
                        edNimBaru.getText().toString(),
                        edNimLama.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmailBaru.getText().toString(),
                        "Kosongkan saja",
                        "72180217"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MahasiswaUpdateActivity.this, MainMhsActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data Tidak Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}