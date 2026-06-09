package com.rentcar.model;

public class Transaksi {
    private int idTransaksi;
    private int idMobil; // Pastikan atribut ini ada
    private String namaMobil;
    private String namaCustomer;
    private String tglPinjam;
    private String tglKembali;
    private double totalHarga;
    private String status;

    public Transaksi(int idTransaksi, int idMobil, String namaMobil, String namaCustomer, String tglPinjam, String tglKembali, double totalHarga, String status) {
        this.idTransaksi = idTransaksi;
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.namaCustomer = namaCustomer;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public int getIdTransaksi() { return idTransaksi; }
    public int getIdMobil() { return idMobil; } // <--- METHOD INI YANG DIBUTUHKAN JSP
    public String getNamaMobil() { return namaMobil; }
    public String getNamaCustomer() { return namaCustomer; }
    public String getTglPinjam() { return tglPinjam; }
    public String getTglKembali() { return tglKembali; }
    public double getTotalHarga() { return totalHarga; }
    public String getStatus() { return status; }
}