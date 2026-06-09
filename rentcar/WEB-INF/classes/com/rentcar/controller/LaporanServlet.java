package com.rentcar.controller;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.rentcar.util.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/laporan")
public class LaporanServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tglMulai = request.getParameter("tgl_mulai");
        String tglAkhir = request.getParameter("tgl_akhir");
        String action = request.getParameter("action");

        // Jika parameter tanggal ada, ambil data dari database
        if (tglMulai != null && !tglMulai.isEmpty() && tglAkhir != null && !tglAkhir.isEmpty()) {
            List<Object[]> dataList = new ArrayList<>();
            String sql = "SELECT t.*, m.merk, m.model, c.nama FROM tbl_transaksi t " +
                         "JOIN tbl_mobil m ON t.id_mobil = m.id_mobil " +
                         "JOIN tbl_customer c ON t.id_customer = c.id_customer " +
                         "WHERE t.tgl_pinjam BETWEEN ? AND ?";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, tglMulai);
                ps.setString(2, tglAkhir);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        dataList.add(new Object[]{rs.getString("merk") + " " + rs.getString("model"), 
                                                 rs.getString("nama"), rs.getString("tgl_pinjam"), 
                                                 rs.getString("tgl_kembali"), rs.getString("status")});
                    }
                }
            } catch (SQLException e) { throw new ServletException("Error DB", e); }

            // Jika action adalah download, buat PDF
            if ("download".equals(action)) {
                exportPDF(dataList, tglMulai, tglAkhir, response);
            } else {
                // Jika tidak, tampilkan preview di JSP
                request.setAttribute("dataList", dataList);
                request.setAttribute("tglMulai", tglMulai);
                request.setAttribute("tglAkhir", tglAkhir);
                request.getRequestDispatcher("laporan.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("laporan.jsp").forward(request, response);
        }
    }

    private void exportPDF(List<Object[]> data, String start, String end, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Laporan_Transaksi.pdf");
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("LAPORAN TRANSAKSI RENTAL"));
            document.add(new Paragraph("Periode: " + start + " s/d " + end));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(5);
            for (String h : new String[]{"Mobil", "Customer", "Tgl Pinjam", "Tgl Kembali", "Status"}) table.addCell(h);
            for (Object[] row : data) { for (Object cell : row) table.addCell(cell.toString()); }
            document.add(table);
            document.close();
        } catch (DocumentException e) { throw new IOException(e); }
    }
}