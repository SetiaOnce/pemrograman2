package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[DashboardServlet] Servlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[DashboardServlet] Processing GET Request");

        // Cek session — jika belum login, redirect ke login
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // FORWARD ke dashboard.jsp — kirim data session ke view
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("[DashboardServlet] Servlet Destroyed");
    }
}
