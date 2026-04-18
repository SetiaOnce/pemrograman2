// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KaryawanController {
    
    // Fungsi Simpan sesuai perintah pdf: karyawanController.simpan(ktpTextField, namaTextField, ruangComboBox, passwordField);
    public void simpan(JTextField ktp, JTextField nama, JComboBox<String> ruang, JPasswordField password) {
        try {
            Connection con = Koneksi.getKoneksi();
            // Menggunakan MD5 untuk enkripsi password sesuai instruksi PDF
            String sql = "INSERT INTO tbkaryawan (ktp, nama, ruang, password) VALUES (?, ?, ?, MD5(?))";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, ktp.getText());
            ps.setString(2, nama.getText());
            ps.setInt(3, Integer.parseInt(ruang.getSelectedItem().toString()));
            ps.setString(4, new String(password.getPassword()));
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil Disimpan!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan: " + e.getMessage());
        }
    }

    // Fungsi Hapus sesuai perintah pdf: karyawanController.hapus(ktpTextField);
    public void hapus(JTextField ktp) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "DELETE FROM tbkaryawan WHERE ktp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ktp.getText());
            
            int rows = ps.executeUpdate();
            if(rows > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "KTP tidak ditemukan.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus: " + e.getMessage());
        }
    }

    // Fungsi Cari saat user menekan Enter di ktpTextField
    public void cari(JTextField ktp, JTextField nama, JComboBox<String> ruang) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "SELECT * FROM tbkaryawan WHERE ktp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ktp.getText());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nama.setText(rs.getString("nama"));
                ruang.setSelectedItem(String.valueOf(rs.getInt("ruang")));
                JOptionPane.showMessageDialog(null, "Data Ditemukan!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}