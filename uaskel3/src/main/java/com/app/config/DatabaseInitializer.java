package com.app.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[DatabaseInitializer] Memulai inisialisasi database...");
        createUsersTable();
        insertDefaultAdmin();
        System.out.println("[DatabaseInitializer] Database siap digunakan!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[DatabaseInitializer] Aplikasi dihentikan");
    }

    private void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id       INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT    NOT NULL UNIQUE, "
                + "password TEXT    NOT NULL, "
                + "fullname TEXT    NOT NULL, "
                + "role     TEXT    NOT NULL)";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("[DatabaseInitializer] Tabel 'users' siap");
        } catch (SQLException e) {
            throw new RuntimeException("Gagal membuat tabel users!", e);
        }
    }

    private void insertDefaultAdmin() {
        String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users (username, password, fullname, role) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            // Cek apakah admin sudah ada
            try (PreparedStatement ps = conn.prepareStatement(checkSql)) {
                ps.setString(1, "admin");
                ResultSet rs = ps.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("[DatabaseInitializer] Admin sudah ada, skip insert");
                    return;
                }
            }

            // Insert data default
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setString(1, "admin");
                ps.setString(2, "admin123");
                ps.setString(3, "Administrator");
                ps.setString(4, "Admin");
                ps.executeUpdate();
                System.out.println("[DatabaseInitializer] User 'admin' berhasil dibuat");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal insert data default!", e);
        }
    }
}
