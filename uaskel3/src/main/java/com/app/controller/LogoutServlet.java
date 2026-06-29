package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[LogoutServlet] Servlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LogoutServlet] Processing GET Request");

        // Ambil session yang ada (jangan buat baru)
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            System.out.println("[LogoutServlet] Session invalidated");
        }

        // REDIRECT ke halaman login
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    public void destroy() {
        System.out.println("[LogoutServlet] Servlet Destroyed");
    }
}
