package com.rentcar.model;

public class Customer {
    private int idCustomer;
    private String nik;
    private String nama;
    private String noTelp;
    private String alamat;

    // Constructor
    public Customer(int idCustomer, String nik, String nama, String noTelp, String alamat) {
        this.idCustomer = idCustomer;
        this.nik = nik;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    // Getters
    public int getIdCustomer() { return idCustomer; }
    public String getNik() { return nik; }
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getAlamat() { return alamat; }
}