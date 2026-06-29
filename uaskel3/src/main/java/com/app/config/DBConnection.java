package com.app.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database disimpan di: C:\Users\<username>\ServletMVCLogin\app.db
    private static final String DB_FOLDER =
            System.getProperty("user.home") + File.separator + "ServletMVCLogin";
    private static final String DB_URL =
            "jdbc:sqlite:" + DB_FOLDER + File.separator + "app.db";

    // Static initializer — dijalankan SEKALI saat class pertama kali dimuat JVM
    static {
        try {
            // Muat SQLite JDBC Driver ke memori
            Class.forName("org.sqlite.JDBC");

            // Buat folder database jika belum ada
            new File(DB_FOLDER).mkdirs();

            System.out.println("[DBConnection] SQLite Driver loaded");
            System.out.println("[DBConnection] DB Path: " + DB_URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC Driver not found!", e);
        }
    }

    // Membuat dan mengembalikan koneksi baru ke database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Menutup koneksi dengan aman (null-safe)
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
