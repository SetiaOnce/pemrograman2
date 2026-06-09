package com.rentcar.controller;

import com.rentcar.util.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/pengembalian")
public class PengembalianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTransaksi = request.getParameter("id_transaksi");
        String idMobil = request.getParameter("id_mobil");

        try (Connection conn = DBConnection.getConnection()) {
            // Update status transaksi menjadi 'Selesai'
            String sqlTransaksi = "UPDATE tbl_transaksi SET status = 'Selesai' WHERE id_transaksi = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlTransaksi)) {
                ps.setString(1, idTransaksi);
                ps.executeUpdate();
            }

            // Update status mobil menjadi 'Tersedia'
            String sqlMobil = "UPDATE tbl_mobil SET status = 'Tersedia' WHERE id_mobil = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlMobil)) {
                ps.setString(1, idMobil);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Redirect kembali ke halaman transaksi agar data ter-refresh
        response.sendRedirect("transaksi");
    }
}