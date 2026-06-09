package com.rentcar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

// Mapping URL langsung dari anotasi (pastikan Tomcat 10+ support ini tanpa web.xml yang panjang)
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        // Sesuai requirement: default admin/123456
        if ("admin".equals(user) && "123456".equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Simpan session
            
            // Redirect ke halaman dashboard (bisa melalui DashboardServlet nantinya)
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        } else {
            request.setAttribute("error", "Username atau Password salah!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}