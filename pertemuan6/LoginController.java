// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginController {

    public boolean validasi(JTextField userId, JPasswordField passwordField) {
        try {
            Connection con = Koneksi.getKoneksi();
            
            // Menggunakan fungsi MD5() bawaan MySQL untuk mencocokkan password
            String sql = "SELECT * FROM tbkaryawan WHERE ktp = ? AND password = MD5(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, userId.getText());
            ps.setString(2, new String(passwordField.getPassword()));
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Jika data ditemukan (login sukses)
                JOptionPane.showMessageDialog(null, "Login Berhasil! Selamat Datang, " + rs.getString("nama"));
                return true;
            } else {
                // Jika data tidak ditemukan
                JOptionPane.showMessageDialog(null, "Login Gagal! User ID (KTP) atau Password salah.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: " + e.getMessage());
            return false;
        }
    }
}