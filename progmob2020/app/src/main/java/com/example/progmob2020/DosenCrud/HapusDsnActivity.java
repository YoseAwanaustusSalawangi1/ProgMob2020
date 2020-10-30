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

public class HapusDsnActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_dsn);

        EditText edNidnHapus = (EditText)findViewById(R.id.editTextHapusDsn);
        pd = new ProgressDialog(HapusDsnActivity.this);
        Button btnDelDsn = (Button)findViewById(R.id.buttonHapusDsn);

        btnDelDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_dsn(
                        edNidnHapus.getText().toString(),
                        "72180217"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusDsnActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(HapusDsnActivity.this, DosenGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusDsnActivity.this, "Data Gagal Dihapus", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}