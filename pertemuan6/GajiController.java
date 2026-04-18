// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GajiController {

    // Fungsi mencari Nama Karyawan berdasarkan KTP
    public void cariKaryawan(JTextField ktp, JTextField namaKaryawan) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "SELECT nama FROM tbkaryawan WHERE ktp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ktp.getText());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                namaKaryawan.setText(rs.getString("nama"));
            } else {
                namaKaryawan.setText("");
                JOptionPane.showMessageDialog(null, "KTP Tidak Ditemukan di Master Karyawan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Fungsi mencari Nama Pekerjaan berdasarkan Kode
    public void cariPekerjaan(JTextField kodePekerjaan, JTextField namaPekerjaan) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "SELECT nama_pekerjaan FROM tbpekerjaan WHERE kode_pekerjaan = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kodePekerjaan.getText());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                namaPekerjaan.setText(rs.getString("nama_pekerjaan"));
            } else {
                namaPekerjaan.setText("");
                JOptionPane.showMessageDialog(null, "Kode Pekerjaan Tidak Ditemukan di Master Pekerjaan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Fungsi Simpan Transaksi Gaji
    public void simpan(JTextField ktp, JTextField kodePekerjaan) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "INSERT INTO tbgaji (ktp, kode_pekerjaan) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, ktp.getText());
            ps.setString(2, kodePekerjaan.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi Gaji Berhasil Disimpan!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Transaksi (Pastikan KTP dan Kode Valid): " + e.getMessage());
        }
    }

    // Fungsi Tampilkan Daftar Transaksi (Menggunakan JOIN SQL)
    public void tampilkanDaftar() {
        try {
            Connection con = Koneksi.getKoneksi();
            // Menggabungkan 3 tabel sekaligus agar outputnya mudah dibaca manusia
            String sql = "SELECT g.id_gaji, k.nama, p.nama_pekerjaan " +
                         "FROM tbgaji g " +
                         "JOIN tbkaryawan k ON g.ktp = k.ktp " +
                         "JOIN tbpekerjaan p ON g.kode_pekerjaan = p.kode_pekerjaan";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            StringBuilder sb = new StringBuilder("--- Daftar Transaksi Gaji ---\n");
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id_gaji"))
                  .append(" | Karyawan: ").append(rs.getString("nama"))
                  .append(" | Pekerjaan: ").append(rs.getString("nama_pekerjaan")).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, sb.toString(), "Data Transaksi Gaji", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}