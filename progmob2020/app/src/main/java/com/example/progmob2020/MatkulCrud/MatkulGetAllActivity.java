package com.example.progmob2020.MatkulCrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmob2020.Adapter.MatkulCRUDRecyclerAdapter;
import com.example.progmob2020.Model.Matkul;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulGetAllActivity extends AppCompatActivity {

    RecyclerView rvMtkl;
    MatkulCRUDRecyclerAdapter mtklAdapter;
    ProgressDialog pd;
    List<Matkul> matkulList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_get_all);

        rvMtkl =(RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matkul>> call = service.getMatkul("72180217");

        call.enqueue(new Callback<List<Matkul>>() {
            @Override
            public void onResponse(Call<List<Matkul>> call, Response<List<Matkul>> response) {
                pd.dismiss();
                matkulList = response.body();
                mtklAdapter = new MatkulCRUDRecyclerAdapter(matkulList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                rvMtkl.setLayoutManager(layoutManager);
                rvMtkl.setAdapter(mtklAdapter);
            }

            @Override
            public void onFailure(Call<List<Matkul>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatkulGetAllActivity.this, "Error",Toast.LENGTH_LONG);
            }
        });
    }
}