// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * ContohJTableCara1
 *
 * Slide 11: Jika menggunakan Cara 1
 * (tanpa membuat kode untuk judul kolom)
 *
 * Pada cara ini, judul kolom langsung dimasukkan
 * lewat konstruktor DefaultTableModel atau array String.
 *
 * Biasanya di NetBeans dibuat via GUI Designer (drag-drop JTable),
 * lalu judul kolom diset lewat property "Model".
 */
public class ContohJTableCara1 extends JFrame {

    private JTable tblData;
    private JScrollPane scrollPane;

    // Judul kolom langsung di-set via array (Cara 1 - tanpa addColumn)
    private String[] judulKolom = {"NIM", "Nama", "Jurusan", "Nilai"};

    // Data awal (opsional)
    private Object[][] dataAwal = {
        {"2024001", "Budi Santoso",   "Informatika", "85"},
        {"2024002", "Siti Rahayu",    "Sistem Informasi", "90"},
        {"2024003", "Ahmad Fauzi",    "Informatika", "78"},
    };

    public ContohJTableCara1() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Contoh JTable - Cara 1");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cara 1: judul kolom langsung lewat konstruktor DefaultTableModel
        // Tidak pakai addColumn() satu per satu
        DefaultTableModel model = new DefaultTableModel(dataAwal, judulKolom);

        tblData = new JTable(model);
        scrollPane = new JScrollPane(tblData);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ContohJTableCara1().setVisible(true);
        });
    }
}