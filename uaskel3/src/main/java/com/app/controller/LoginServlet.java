package com.app.controller;

import com.app.dao.UserDAO;
import com.app.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    // LIFECYCLE 1: Dipanggil SEKALI saat Servlet pertama kali dimuat oleh Tomcat
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        System.out.println("[LoginServlet] Servlet Initialized");
    }

    // LIFECYCLE 2: Dipanggil setiap ada GET request ke /login
    // Fungsi: Menampilkan halaman login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LoginServlet] Processing GET Request");

        // Jika user sudah login, langsung redirect ke dashboard
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }

        // FORWARD ke login.jsp — URL di browser tetap /login
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    // LIFECYCLE 2: Dipanggil setiap ada POST request ke /login
    // Fungsi: Memproses form login
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LoginServlet] Processing POST Request");

        // Ambil input dari form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validasi melalui DAO
        User user = userDAO.findByUsernameAndPassword(username, password);

        if (user != null) {
            // LOGIN BERHASIL — buat session baru
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("fullname", user.getFullname());
            session.setAttribute("role", user.getRole());

            // REDIRECT ke dashboard — URL di browser berubah ke /dashboard
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            // LOGIN GAGAL — kirim pesan error kembali ke login.jsp
            request.setAttribute("error", "Username atau Password salah");

            // FORWARD ke login.jsp — URL di browser tetap /login
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    // LIFECYCLE 3: Dipanggil SEKALI saat Servlet dihancurkan oleh Tomcat
    @Override
    public void destroy() {
        System.out.println("[LoginServlet] Servlet Destroyed");
    }
}
