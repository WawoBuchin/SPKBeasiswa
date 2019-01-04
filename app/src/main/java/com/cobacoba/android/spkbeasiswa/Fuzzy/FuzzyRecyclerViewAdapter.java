package com.cobacoba.android.spkbeasiswa.Fuzzy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cobacoba.android.spkbeasiswa.DBHelper;
import com.cobacoba.android.spkbeasiswa.OnItemClickListener;
import com.cobacoba.android.spkbeasiswa.R;

import java.util.ArrayList;


public class FuzzyRecyclerViewAdapter extends RecyclerView.Adapter<FuzzyRecyclerViewAdapter.ViewHolder>{
    private ArrayList<FuzzyModel> listlaporan;
    private OnItemClickListener listener;

    Context context;

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView tvno,tvnim,tvnama,tvjurusan, tvsemester, tvstatus;
        int no;
        //String id;
        FuzzyModel laporan;
        //pengisian variabel
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //id = "";
             no = 1;
            laporan = new FuzzyModel();
            tvno = itemView.findViewById(R.id.tvNo);
            tvnim = itemView.findViewById(R.id.tvNIM);
            tvnama = itemView.findViewById(R.id.tvNama);
            tvjurusan = itemView.findViewById(R.id.tvJurusan);
            tvsemester = itemView.findViewById(R.id.tvSemester);
            tvstatus = itemView.findViewById(R.id.tvStatus);
        }


    }
    public FuzzyRecyclerViewAdapter(ArrayList<FuzzyModel> listlaporan) {
        this.listlaporan = listlaporan;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laporan, parent, false);
        return new FuzzyRecyclerViewAdapter().ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FuzzyRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        final DBHelper dbhelper = new DBHelper(context,null);
        viewHolder.tvno.setText(String.valueOf(1));
        viewHolder.tvnim.setText(listlaporan.get(position).getNim());
        viewHolder.tvnama.setText(listlaporan.get(position).getNama());
        viewHolder.tvjurusan.setText(listlaporan.get(position).getJurusan());
        viewHolder.tvsemester.setText(listlaporan.get(position).getSemester());
        viewHolder.tvstatus.setText(listlaporan.get(position).getStatus());
        //viewHolder.id = listlaporan.get(position).get();

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
