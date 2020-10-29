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
import com.example.progmob2020.Model.Dosen;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dsn,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen d = dosenList.get(position);

        holder.tvNama.setText(d.getNama());
        holder.tvNidn.setText(d.getNidn());
        holder.tvAlamat.setText(d.getAlamat());
        holder.tvEmail.setText(d.getEmail());
        holder.tvGelar.setText(d.getGelar());
        //holder.tvNoTelp.setText(m.getNoTelp());
        holder.d = d;
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNidn, tvGelar, tvAlamat, tvEmail;
        private RecyclerView rvGetDsnAll;
        Dosen d;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNidn = itemView.findViewById(R.id.tvNidn);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvGelar = itemView.findViewById(R.id.tvGelar);
            //tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
            rvGetDsnAll = itemView.findViewById(R.id.rvGetDsnAll);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DosenUpdateActivity.class);
                    intent.putExtra("nidn",d.getNidn());
                    intent.putExtra("nama",d.getNama());
                    intent.putExtra("alamat",d.getAlamat());
                    intent.putExtra("email",d.getEmail());
                    intent.putExtra("gelar",d.getGelar());

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
