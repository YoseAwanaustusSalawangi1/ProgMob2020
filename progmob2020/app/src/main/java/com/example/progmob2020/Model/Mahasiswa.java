package com.example.progmob2020.Model;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String NoTelp;

    public Mahasiswa(String nama, String nim, String NoTelp) {
        this.nama = nama;
        this.nim = nim;
        this.NoTelp = NoTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNoTelp() {
        return NoTelp;
    }

    public void setNoTelp(String NoTelp) {
        this.NoTelp = NoTelp;
    }
}
