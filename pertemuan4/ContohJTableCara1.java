// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContohJTableCara1 extends JFrame {

    private JTable tblData;

    public ContohJTableCara1() {
        initComponents();
    }

    private void initComponents() {
        setTitle("JTable - Cara 1");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Slide 11 (Cara 1): judul kolom langsung via konstruktor
        // tanpa membuat kode untuk judul kolom (addColumn)
        String[] judulKolom = {"NIM", "Nama", "Jurusan", "Nilai"};
        DefaultTableModel model = new DefaultTableModel(null, judulKolom);

        tblData = new JTable(model);
        add(new JScrollPane(tblData), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new ContohJTableCara1().setVisible(true);
    }
}