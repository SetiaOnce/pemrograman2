package com.rentcar.controller;

import com.rentcar.model.Mobil;
import com.rentcar.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mobil")
public class MobilServlet extends HttpServlet {
    
    // Menangani Read & Delete
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                deleteMobil(id);
                response.sendRedirect(request.getContextPath() + "/mobil");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Default: Ambil semua data dan tampilkan ke JSP
        request.setAttribute("listMobil", getAllMobil());
        request.getRequestDispatcher("/mobil.jsp").forward(request, response);
    }

    // Menangani Create & Update
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id_mobil");
        String plat = request.getParameter("plat_nomor");
        String merk = request.getParameter("merk");
        String model = request.getParameter("model");
        int tahun = Integer.parseInt(request.getParameter("tahun"));
        double harga = Double.parseDouble(request.getParameter("harga_per_hari"));
        String status = request.getParameter("status");

        try (Connection conn = DBConnection.getConnection()) {
            if (idStr == null || idStr.isEmpty()) {
                // INSERT DATA BARU
                String sql = "INSERT INTO tbl_mobil (plat_nomor, merk, model, tahun, harga_per_hari, status) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, plat);
                    ps.setString(2, merk);
                    ps.setString(3, model);
                    ps.setInt(4, tahun);
                    ps.setDouble(5, harga);
                    ps.setString(6, status);
                    ps.executeUpdate();
                }
            } else {
                // UPDATE DATA EKSISTING
                int id = Integer.parseInt(idStr);
                String sql = "UPDATE tbl_mobil SET plat_nomor=?, merk=?, model=?, tahun=?, harga_per_hari=?, status=? WHERE id_mobil=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, plat);
                    ps.setString(2, merk);
                    ps.setString(3, model);
                    ps.setInt(4, tahun);
                    ps.setDouble(5, harga);
                    ps.setString(6, status);
                    ps.setInt(7, id);
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/mobil");
    }

    // Helper: Ambil data dari MySQL
    private List<Mobil> getAllMobil() {
        List<Mobil> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_mobil ORDER BY id_mobil DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Mobil(
                    rs.getInt("id_mobil"),
                    rs.getString("plat_nomor"),
                    rs.getString("merk"),
                    rs.getString("model"),
                    rs.getInt("tahun"),
                    rs.getDouble("harga_per_hari"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Helper: Hapus data
    private void deleteMobil(int id) {
        String sql = "DELETE FROM tbl_mobil WHERE id_mobil = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}