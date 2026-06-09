package com.rentcar.model;

public class Mobil {
    private int idMobil;
    private String platNomor;
    private String merk;
    private String model;
    private int tahun;
    private double hargaPerHari;
    private String status;

    // Constructor Kosong
    public Mobil() {}

    // Constructor Lengkap
    public Mobil(int idMobil, String platNomor, String merk, String model, int tahun, double hargaPerHari, String status) {
        this.idMobil = idMobil;
        this.platNomor = platNomor;
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.hargaPerHari = hargaPerHari;
        this.status = status;
    }

    // Getter dan Setter
    public int getIdMobil() { return idMobil; }
    public void setIdMobil(int idMobil) { this.idMobil = idMobil; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getTahun() { return tahun; }
    public void setTahun(int tahun) { this.tahun = tahun; }

    public double getHargaPerHari() { return hargaPerHari; }
    public void setHargaPerHari(double hargaPerHari) { this.hargaPerHari = hargaPerHari; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}