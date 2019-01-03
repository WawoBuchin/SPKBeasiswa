package com.cobacoba.android.spkbeasiswa.Fuzzy;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cobacoba.android.spkbeasiswa.DBHelper;
import com.cobacoba.android.spkbeasiswa.R;

import java.util.List;

public class FuzzyMain extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    String nama;
    EditText etUang,etTang,etIPK;
    TextView tvSkor;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mahasiswa);

        etUang = (EditText) findViewById(R.id.itUang);
        etTang = (EditText) findViewById(R.id.itTang);
        etIPK = (EditText) findViewById(R.id.itipk);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        // Spinner element
        spinner = (Spinner)findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        loadSpinnerData();
    }


    private void loadSpinnerData(){
        // database handler
        DBHelper dbHelper = new DBHelper(this, null);

        // Spinner Drop down elements
        List<String> lables = dbHelper.getAllMahasiswas();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab){
            //Toast.makeText(getBaseContext(),"Data Saved" + et_SubjectName.getText().toString() + teacher + et_SubjectRoom.getText().toString(),Toast.LENGTH_SHORT).show();
            if (!nama.equals(" please select ") && !etUang.getText().toString().equals("") && !etTang.getText().toString().equals("") &&  !etIPK.getText().toString().equals("")) {
                DBHelper dbHelper = new DBHelper(getBaseContext(), null);
                String uang = etUang.getText().toString();
                String tang = etTang.getText().toString();
                Double ipk = Double.parseDouble(String.valueOf(etIPK));
                Double eko = Double.valueOf(uang)/Double.valueOf(tang);
                Double derajat = Double.valueOf(0);

                if (eko <= 750000 && ipk <= 2 ){
                    derajat += 1;
                }else if (eko >= 750000 && eko <= 1000000){
                    derajat
                }

                FuzzyMain fuzzy = new FuzzyModel(nama,uang, tang, ipk, );
                if(dbHelper.insertMahasiswa(mahasiswa) != -1){
                    Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_SHORT).show();
                    //kosongkanData();
                    //startActivity(new Intent(this, TeacherActivity.class));
                    onBackPressed();
                } else{
                    Toast.makeText(getBaseContext(),"Data Error",Toast.LENGTH_SHORT).show();
                }
                dbHelper.close();
            } else{
                Toast.makeText(getBaseContext(),"please fill in the empty field",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (adapterView.getId() == R.id.spinner){
            jur = adapterView.getItemAtPosition(position).toString();
            Toast.makeText(adapterView.getContext(),"You selected : " + jur, Toast.LENGTH_LONG).show();
        }



        //Toast.makeText(adapterView.getContext(), "You selected: " + teacher,
        //Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
