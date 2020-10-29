package com.example.progmob2020.DosenCrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmob2020.Adapter.DosenCRUDRecyclerAdapter;
import com.example.progmob2020.Model.Dosen;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenGetAllActivity extends AppCompatActivity {

    RecyclerView rvDsn;
    DosenCRUDRecyclerAdapter dsnAdapter;
    ProgressDialog pd;
    List<Dosen> dosenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_get_all);

        rvDsn =(RecyclerView)findViewById(R.id.rvGetDsnAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Dosen>> call = service.getDosen("72180217");

        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {
                pd.dismiss();
                dosenList = response.body();
                dsnAdapter = new DosenCRUDRecyclerAdapter(dosenList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DosenGetAllActivity.this);
                rvDsn.setLayoutManager(layoutManager);
                rvDsn.setAdapter(dsnAdapter);
            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(DosenGetAllActivity.this, "Error",Toast.LENGTH_LONG);
            }
        });
    }
}