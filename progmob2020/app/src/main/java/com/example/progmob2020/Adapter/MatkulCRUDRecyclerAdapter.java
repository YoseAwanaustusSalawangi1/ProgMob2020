package com.example.progmob2020.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmob2020.DosenCrud.DosenUpdateActivity;
import com.example.progmob2020.MatkulCrud.MatkulUpdateActivity;
import com.example.progmob2020.Model.Matkul;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Matkul> matkulList;

    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matkulList = new ArrayList<>();
    }

    public MatkulCRUDRecyclerAdapter(List<Matkul> matkulList) {
        this.matkulList = matkulList;
    }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    public void setMatkulList(List<Matkul> matkulList) {
        this.matkulList = matkulList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_matkul,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matkul ml = matkulList.get(position);

        holder.tvNama.setText(ml.getNama());
        holder.tvKode.setText(ml.getKode());
        holder.tvHari.setText(ml.getHari());
        holder.tvSesi.setText(ml.getSesi());
        holder.tvSks.setText(ml.getSks());
        //holder.tvNoTelp.setText(m.getNoTelp());
        holder.ml = ml;
    }

    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvKode, tvHari, tvSesi, tvSks;
        private RecyclerView rvGetMatkulAll;
        Matkul ml;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaMatkul);
            tvKode= itemView.findViewById(R.id.tvKodeMatkul);
            tvHari = itemView.findViewById(R.id.tvHari);
            tvSesi = itemView.findViewById(R.id.tvSesi);
            tvSks = itemView.findViewById(R.id.tvSks);
            //tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
            rvGetMatkulAll = itemView.findViewById(R.id.rvGetMatkulAll);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatkulUpdateActivity.class);
                    intent.putExtra("nama",ml.getNama());
                    intent.putExtra("kode",ml.getKode());
                    intent.putExtra("hari",ml.getHari());
                    intent.putExtra("sesi",ml.getSesi());
                    intent.putExtra("sks",ml.getSks());
                    
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
