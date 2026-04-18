// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PekerjaanController {

    // Fungsi Simpan
    public void simpan(JTextField kodePekerjaan, JTextField namaPekerjaan, JComboBox<String> jumlahTugas) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "INSERT INTO tbpekerjaan (kode_pekerjaan, nama_pekerjaan, jumlah_tugas) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, kodePekerjaan.getText());
            ps.setString(2, namaPekerjaan.getText());
            ps.setInt(3, Integer.parseInt(jumlahTugas.getSelectedItem().toString()));
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pekerjaan Berhasil Disimpan!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan: " + e.getMessage());
        }
    }

    // Fungsi Hapus
    public void hapus(JTextField kodePekerjaan) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "DELETE FROM tbpekerjaan WHERE kode_pekerjaan = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kodePekerjaan.getText());
            
            int rows = ps.executeUpdate();
            if(rows > 0) {
                JOptionPane.showMessageDialog(null, "Data Pekerjaan Berhasil Dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Kode Pekerjaan tidak ditemukan.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus: " + e.getMessage());
        }
    }

    // Fungsi Cari saat user menekan Enter di kodePekerjaanTextField
    public void cari(JTextField kodePekerjaan, JTextField namaPekerjaan, JComboBox<String> jumlahTugas) {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "SELECT * FROM tbpekerjaan WHERE kode_pekerjaan = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kodePekerjaan.getText());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                namaPekerjaan.setText(rs.getString("nama_pekerjaan"));
                jumlahTugas.setSelectedItem(String.valueOf(rs.getInt("jumlah_tugas")));
                JOptionPane.showMessageDialog(null, "Data Ditemukan!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Fungsi Tampilkan Daftar (Lihat Button)
    public void tampilkanDaftar() {
        try {
            Connection con = Koneksi.getKoneksi();
            String sql = "SELECT * FROM tbpekerjaan";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            StringBuilder sb = new StringBuilder("--- Daftar Pekerjaan ---\n");
            while (rs.next()) {
                sb.append("Kode: ").append(rs.getString("kode_pekerjaan"))
                  .append(" | Nama: ").append(rs.getString("nama_pekerjaan"))
                  .append(" | Tugas: ").append(rs.getInt("jumlah_tugas")).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, sb.toString(), "Daftar Pekerjaan", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}