package com.rentcar.controller;

import com.rentcar.model.*;
import com.rentcar.util.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/transaksi")
public class TransaksiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listTransaksi", getAllTransaksi());
        request.setAttribute("listMobil", getListMobil());
        request.setAttribute("listCustomer", getListCustomer());
        request.getRequestDispatcher("/transaksi.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idMobil = request.getParameter("id_mobil");
        String idCustomer = request.getParameter("id_customer");
        String tglPinjam = request.getParameter("tgl_pinjam");
        String tglKembali = request.getParameter("tgl_kembali");
        String total = request.getParameter("total_harga");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO tbl_transaksi (id_mobil, id_customer, tgl_pinjam, tgl_kembali, total_harga, status) VALUES (?, ?, ?, ?, ?, 'Dipinjam')";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, idMobil); ps.setString(2, idCustomer);
                ps.setString(3, tglPinjam); ps.setString(4, tglKembali); ps.setString(5, total);
                ps.executeUpdate();

                String sqlUpdate = "UPDATE tbl_mobil SET status = 'Disewa' WHERE id_mobil = ?";
                try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdate)) {
                    ps2.setString(1, idMobil);
                    ps2.executeUpdate();
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        response.sendRedirect("transaksi");
    }

    private List<Transaksi> getAllTransaksi() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT t.*, m.merk, m.model, c.nama FROM tbl_transaksi t " +
                     "JOIN tbl_mobil m ON t.id_mobil = m.id_mobil JOIN tbl_customer c ON t.id_customer = c.id_customer";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Transaksi(
                    rs.getInt("id_transaksi"), 
                    rs.getInt("id_mobil"), // Pastikan id_mobil diambil dari database
                    rs.getString("merk") + " " + rs.getString("model"), 
                    rs.getString("nama"), 
                    rs.getString("tgl_pinjam"), 
                    rs.getString("tgl_kembali"), 
                    rs.getDouble("total_harga"), 
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    private List<Mobil> getListMobil() {
        List<Mobil> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_mobil WHERE status='Tersedia'")) {
            while (rs.next()) list.add(new Mobil(rs.getInt("id_mobil"), rs.getString("plat_nomor"), rs.getString("merk"), rs.getString("model"), rs.getInt("tahun"), rs.getDouble("harga_per_hari"), rs.getString("status")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    private List<Customer> getListCustomer() {
        List<Customer> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_customer")) {
            while (rs.next()) list.add(new Customer(rs.getInt("id_customer"), rs.getString("nik"), rs.getString("nama"), rs.getString("no_telp"), rs.getString("alamat")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}