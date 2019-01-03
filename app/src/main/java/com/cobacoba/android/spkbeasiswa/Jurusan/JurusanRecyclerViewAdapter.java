package com.cobacoba.android.spkbeasiswa.Jurusan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cobacoba.android.spkbeasiswa.DBHelper;
import com.cobacoba.android.spkbeasiswa.OnItemClickListener;
import com.cobacoba.android.spkbeasiswa.R;

import java.util.ArrayList;

public class JurusanRecyclerViewAdapter extends RecyclerView.Adapter<JurusanRecyclerViewAdapter.ViewHolder> {
    private ArrayList<JurusanModel> listJurusan;
    private OnItemClickListener listener;

    Context context;

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView tvKJur,tvJur;
        Button tool;
        String id;
        JurusanModel jurusan;
        //pengisian variabel
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = "";

            jurusan = new JurusanModel();
            tvKJur = itemView.findViewById(R.id.tvKJur);
            tvJur = itemView.findViewById(R.id.tvJur);
            tool = itemView.findViewById(R.id.btncrud);
        }
    }

    public JurusanRecyclerViewAdapter(ArrayList<JurusanModel> listJurusan) {
        this.listJurusan = listJurusan;
    }

    public void deleteItem(int position){
        listJurusan.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //tempat item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jurusan, parent, false);
        return new ViewHolder(v);
    }

    @Override
    //set data ke tampilan
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final DBHelper dbhelper = new DBHelper(context,null);

        viewHolder.tvKJur.setText(listJurusan.get(position).getKode());
        viewHolder.tvJur.setText(listJurusan.get(position).getNama());
        viewHolder.id = listJurusan.get(position).getId();

        final Button tool = viewHolder.tool;
        viewHolder.tool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, tool);
                popup.inflate(R.menu.menu_crud);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                Intent intent = new Intent (context, UpdateJurusan.class);
                                intent.putExtra("id",viewHolder.id);
                                context.startActivity(intent);
                                //dbhelper.updateTeacher(viewHolder.teacher);
                                //Toast.makeText(context,"edit" +viewHolder.teacher.getName()  ,Toast.LENGTH_SHORT).show();

                                return true;
                            case R.id.delete:
                                dbhelper.deleteJurusan(viewHolder.id);
                                deleteItem(viewHolder.getAdapterPosition());
                                Toast.makeText(context,"delete",Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listJurusan != null ? listJurusan.size() : 0;
    }


    public void setOnItemClickLister(OnItemClickListener listener){
        this.listener = listener;
    }


}