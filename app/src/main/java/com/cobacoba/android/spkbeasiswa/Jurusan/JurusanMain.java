package com.cobacoba.android.spkbeasiswa.Jurusan;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cobacoba.android.spkbeasiswa.DBHelper;
import com.cobacoba.android.spkbeasiswa.R;

public class JurusanMain extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rv;
    FloatingActionButton bu;
    JurusanRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        rv = findViewById(R.id.listJurusan);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adapter = new JurusanRecyclerViewAdapter(new DBHelper(this,null).getAllJurusan());
        rv.setAdapter(adapter);
        bu = findViewById(R.id.fab);
        bu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab){
            startActivity(new Intent(this,InsertJurusan.class));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_jurusan_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        rv = findViewById(R.id.listJurusan);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adapter = new JurusanRecyclerViewAdapter(new DBHelper(this,null).getAllJurusan());
        rv.setAdapter(adapter);
        bu = findViewById(R.id.fab);
        bu.setOnClickListener(this);
    }


    /*
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_reminder, popup.getMenu());
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.edit:
                // do your code
                return true;
            case R.id.delete:
                // do your code
                return true;
            default:
                return false;
        }
    }*/




}