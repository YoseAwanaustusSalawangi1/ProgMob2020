package com.example.progmob2020.MatkulCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.DosenCrud.DosenUpdateActivity;
import com.example.progmob2020.DosenCrud.MainDsnActivity;
import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_update);

        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaMatkulBaru);
        EditText edKodeBaru= (EditText)findViewById(R.id.editTextKodeMatkulBaru);
        EditText edHariBaru = (EditText)findViewById(R.id.editTextHariBaru);
        EditText edSesiBaru = (EditText)findViewById(R.id.editTextSesiBaru);
        EditText edSksBaru = (EditText)findViewById(R.id.editTextSksBaru);
        EditText edKodeLama = (EditText)findViewById(R.id.editTextKodeCari);
        Button btnUpdateMtkl = (Button)findViewById(R.id.buttonUbahMatkul);
        pd = new ProgressDialog(MatkulUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNamaBaru.setText(data.getStringExtra("nama"));
            edKodeBaru.setText(data.getStringExtra("kode"));
            edHariBaru.setText(data.getStringExtra("hari"));
            edSesiBaru.setText(data.getStringExtra("sesi"));
            edSksBaru.setText(data.getStringExtra("sks"));
            edKodeLama.setText(data.getStringExtra("kode"));
        }

        btnUpdateMtkl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mtkl(
                        edNamaBaru.getText().toString(),
                        edKodeBaru.getText().toString(),
                        edHariBaru.getText().toString(),
                        edSesiBaru.getText().toString(),
                        edSksBaru.getText().toString(),
                        edKodeLama.getText().toString(),
                        "72180217"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MatkulUpdateActivity.this, MainMatkulActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "Data Tidak Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}