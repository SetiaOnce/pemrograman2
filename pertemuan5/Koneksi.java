// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    public static void main(String[] args) {
        // Ganti sesuai dengan database Anda
        String url = "jdbc:mysql://127.0.0.1:3306/dbaplikasigajikaryawan";
        String username = "root";
        String password = "123456";

        try {
            // Membuka koneksi
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi ke database MySQL berhasil!");
            
            // Jangan lupa tutup koneksi jika sudah selesai
            connection.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal terkoneksi ke database.");
            e.printStackTrace();
        }
    }
}