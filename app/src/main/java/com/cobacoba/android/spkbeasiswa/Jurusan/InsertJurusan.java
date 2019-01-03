package com.cobacoba.android.spkbeasiswa.Jurusan;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cobacoba.android.spkbeasiswa.DBHelper;
import com.cobacoba.android.spkbeasiswa.R;

public class InsertJurusan extends AppCompatActivity implements View.OnClickListener{
    EditText txtTitle, txtDesc;
    FloatingActionButton fabSimpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_jurusan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        txtTitle = (EditText) findViewById(R.id.itTitle);
        txtDesc = (EditText) findViewById(R.id.itDesc);
        fabSimpan = findViewById(R.id.fab);
        fabSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            if (!txtTitle.getText().toString().equals("") && !txtDesc.getText().toString().equals("")) {
                DBHelper dbAdapter = new DBHelper(getBaseContext(), null);
                String title = txtTitle.getText().toString();
                String desc = txtDesc.getText().toString();

                JurusanModel jurusan = new JurusanModel(title, desc);
                if (dbAdapter.insertJurusan(jurusan) != -1) {
                    Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                    //kosongkanData();
                    //startActivity(new Intent(this, TeacherActivity.class));
                    onBackPressed();
                } else {
                    Toast.makeText(getBaseContext(), "Data Error", Toast.LENGTH_SHORT).show();
                }
                dbAdapter.close();
            } else {
                Toast.makeText(getBaseContext(), "please fill in the empty field", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void kosongkanData () {
        txtTitle.setText("");
        txtDesc.setText("");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}