package com.rentcar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Alamat database MySQL (default port 3306) dan nama database: db_rentcar
    private static final String URL = "jdbc:mysql://localhost:3306/db_rentcar?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";     // <-- Sesuaikan username MySQL kamu
    private static final String PASSWORD = "";     // <-- Sesuaikan password MySQL kamu
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Menggunakan Driver MySQL terbaru
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi MySQL Berhasil!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi MySQL Gagal: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection(); 
    }
}