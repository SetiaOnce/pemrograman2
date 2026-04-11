// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016


import java.sql.*;

public class DatabaseExample {
    public static void main(String[] args) {
        // Ganti dengan URL, user, dan password database kamu
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TrafficDB";
        String user = "sa";
        String pass = "password123";

        // Menggunakan try-with-resources agar koneksi otomatis tertutup
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Koneksi Berhasil!");

            // 1. Membuat Query
            String sql = "SELECT id, jenis_kendaraan, jumlah FROM monitoring_trafik";
            Statement stmt = conn.createStatement();
            
            // 2. Eksekusi Query
            ResultSet rs = stmt.executeQuery(sql);

            // 3. Menampilkan Hasil
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Jenis: " + rs.getString("jenis_kendaraan") + 
                                   ", Jumlah: " + rs.getInt("jumlah"));
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}