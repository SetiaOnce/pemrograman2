// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudMahasiswa {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/mhs";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("=== Koneksi Database 'MHS' Berhasil ===");

            // ==========================================
            // 2. TEST INSERT (Menambah Data)
            // ==========================================
            System.out.println("\n[1] Menjalankan perintah INSERT...");
            String sqlInsert = "INSERT INTO datamhs (nim, nama, semester, kelas) VALUES (?, ?, ?, ?)";
            PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);
            pstInsert.setString(1, "12345678");
            pstInsert.setString(2, "Budi Santoso");
            pstInsert.setInt(3, 3);
            pstInsert.setString(4, "A");
            
            int barisInsert = pstInsert.executeUpdate();
            if (barisInsert > 0) {
                System.out.println("Berhasil menambahkan data mahasiswa!");
            }

            // ==========================================
            // 3. TEST SELECT (Menampilkan Data)
            // ==========================================
            tampilkanData(conn);

            // ==========================================
            // 4. TEST UPDATE (Mengubah Data)
            // ==========================================
            System.out.println("\n[2] Menjalankan perintah UPDATE...");
            String sqlUpdate = "UPDATE datamhs SET nama = ?, semester = ?, kelas = ? WHERE nim = ?";
            PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);
            pstUpdate.setString(1, "Budi Santoso (Updated)");
            pstUpdate.setInt(2, 4);                          
            pstUpdate.setString(3, "B");                     
            pstUpdate.setString(4, "12345678");              
            
            int barisUpdate = pstUpdate.executeUpdate();
            if (barisUpdate > 0) {
                System.out.println("Berhasil mengupdate data mahasiswa!");
            }

            tampilkanData(conn); // Tampilkan lagi untuk melihat perubahannya

            // ==========================================
            // 5. TEST DELETE (Menghapus Data)
            // ==========================================
            System.out.println("\n[3] Menjalankan perintah DELETE...");
            String sqlDelete = "DELETE FROM datamhs WHERE nim = ?";
            PreparedStatement pstDelete = conn.prepareStatement(sqlDelete);
            pstDelete.setString(1, "12345678"); // NIM yang akan dihapus
            
            int barisDelete = pstDelete.executeUpdate();
            if (barisDelete > 0) {
                System.out.println("Berhasil menghapus data mahasiswa!");
            }

            tampilkanData(conn);

            // 6. Menutup Koneksi
            conn.close();
            System.out.println("\n=== Program Selesai, Koneksi Ditutup ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method bantuan untuk menampilkan isi tabel (SELECT)
    private static void tampilkanData(Connection conn) {
        System.out.println("\n--- Menampilkan Isi Tabel 'datamhs' ---");
        try {
            String sqlSelect = "SELECT * FROM datamhs";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            
            boolean adaData = false;
            while (rs.next()) {
                adaData = true;
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                int semester = rs.getInt("semester");
                String kelas = rs.getString("kelas");
                
                System.out.println("NIM: " + nim + ", Nama: " + nama + ", Sem: " + semester + ", Kelas: " + kelas);
            }
            
            if (!adaData) {
                System.out.println("(Tabel Kosong)");
            }
            System.out.println("---------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}