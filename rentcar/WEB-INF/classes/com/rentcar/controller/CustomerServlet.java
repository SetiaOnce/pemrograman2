package com.rentcar.controller;

import com.rentcar.model.Customer;
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

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                deleteCustomer(id);
                response.sendRedirect(request.getContextPath() + "/customer");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listCustomer", getAllCustomer());
        request.getRequestDispatcher("/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id_customer");
        String nik = request.getParameter("nik");
        String nama = request.getParameter("nama");
        String noTelp = request.getParameter("no_telp");
        String alamat = request.getParameter("alamat");

        try (Connection conn = DBConnection.getConnection()) {
            if (idStr == null || idStr.isEmpty()) {
                String sql = "INSERT INTO tbl_customer (nik, nama, no_telp, alamat) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, nik);
                    ps.setString(2, nama);
                    ps.setString(3, noTelp);
                    ps.setString(4, alamat);
                    ps.executeUpdate();
                }
            } else {
                int id = Integer.parseInt(idStr);
                String sql = "UPDATE tbl_customer SET nik=?, nama=?, no_telp=?, alamat=? WHERE id_customer=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, nik);
                    ps.setString(2, nama);
                    ps.setString(3, noTelp);
                    ps.setString(4, alamat);
                    ps.setInt(5, id);
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/customer");
    }

    private List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_customer ORDER BY id_customer DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Customer(
                    rs.getInt("id_customer"),
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void deleteCustomer(int id) {
        String sql = "DELETE FROM tbl_customer WHERE id_customer = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}