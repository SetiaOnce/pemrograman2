import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class Koneksi - Handle koneksi ke database MySQL
 * 
 * Penjelasan:
 * - Static block memuat JDBC driver ketika class di-load
 * - getConnection() mengembalikan Connection object
 * - Jika sudah ada koneksi yang aktif, reuse koneksi tersebut
 * - URL, USER, PASSWORD dapat disesuaikan sesuai konfigurasi MySQL Anda
 */
public class Koneksi {
    // Konfigurasi database - SESUAIKAN DENGAN SETTING ANDA
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_pemrograman2";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn;

    // Static block - dijalankan saat class di-load pertama kali
    static {
        try {
            // Load JDBC Driver untuk MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ JDBC Driver berhasil di-load");
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Driver tidak ditemukan: " + e.getMessage());
        }
    }

    /**
     * Method untuk mendapatkan koneksi database
     * 
     * @return Connection object jika berhasil, null jika gagal
     * 
     * Proses:
     * 1. Cek apakah koneksi sudah ada dan masih aktif
     * 2. Jika tidak ada atau sudah ditutup, buat koneksi baru
     * 3. Return koneksi ke database
     */
    public static Connection getConnection() {
        try {
            // Cek apakah conn null atau sudah ditutup
            if (conn == null || conn.isClosed()) {
                // Buat koneksi baru
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✓ Koneksi ke database berhasil!");
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("✗ Koneksi gagal: " + e.getMessage());
            return null;
        }
    }

    /**
     * Method untuk menutup koneksi
     * 
     * Gunakan method ini ketika aplikasi ditutup atau tidak lagi membutuhkan koneksi
     */
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Koneksi ditutup");
            }
        } catch (SQLException e) {
            System.out.println("Error menutup koneksi: " + e.getMessage());
        }
    }
}