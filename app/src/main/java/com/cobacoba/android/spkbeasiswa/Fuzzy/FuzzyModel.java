package com.cobacoba.android.spkbeasiswa.Fuzzy;

public class FuzzyModel {
    String id_fuzzy;
    String nama_fuzzy;
    String uang_fuzzy;
    String tang_fuzzy;
    String skor_fuzzy;

    public FuzzyModel() {
    }

    public FuzzyModel(String id_fuzzy, String nama_fuzzy, String uang_fuzzy, String tang_fuzzy, String skor_fuzzy) {
        this.id_fuzzy = id_fuzzy;
        this.nama_fuzzy = nama_fuzzy;
        this.uang_fuzzy = uang_fuzzy;
        this.tang_fuzzy = tang_fuzzy;
        this.skor_fuzzy = skor_fuzzy;
    }

    public FuzzyModel(String nama_fuzzy, String uang_fuzzy, String tang_fuzzy, String skor_fuzzy) {
        this.nama_fuzzy = nama_fuzzy;
        this.uang_fuzzy = uang_fuzzy;
        this.tang_fuzzy = tang_fuzzy;
        this.skor_fuzzy = skor_fuzzy;
    }

    public String getId_fuzzy() {
        return id_fuzzy;
    }

    public void setId_fuzzy(String id_fuzzy) {
        this.id_fuzzy = id_fuzzy;
    }

    public String getNama_fuzzy() {
        return nama_fuzzy;
    }

    public void setNama_fuzzy(String nama_fuzzy) {
        this.nama_fuzzy = nama_fuzzy;
    }

    public String getUang_fuzzy() {
        return uang_fuzzy;
    }

    public void setUang_fuzzy(String uang_fuzzy) {
        this.uang_fuzzy = uang_fuzzy;
    }

    public String getTang_fuzzy() {
        return tang_fuzzy;
    }

    public void setTang_fuzzy(String tang_fuzzy) {
        this.tang_fuzzy = tang_fuzzy;
    }

    public String getSkor_fuzzy() {
        return skor_fuzzy;
    }

    public void setSkor_fuzzy(String skor_fuzzy) {
        this.skor_fuzzy = skor_fuzzy;
    }
}
