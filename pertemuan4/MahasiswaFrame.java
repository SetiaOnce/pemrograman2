// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MahasiswaFrame extends JInternalFrame {

    // Slide 7 (Cara 2): deklarasi var model table
    private DefaultTableModel nmVarmodel;

    private JTable tblMahasiswa;

    public MahasiswaFrame() {
        initComponents();
    }

    private void initComponents() {
        // Slide 16: JInternalFrame
        setTitle("Data Mahasiswa");
        setSize(500, 350);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setLocation(20, 20);

        setLayout(new BorderLayout());

        // Slide 7 (Cara 2): membentuk judul kolom via kode
        nmVarmodel = new DefaultTableModel();

        tblMahasiswa = new JTable();
        tblMahasiswa.setModel(nmVarmodel);          // namaVarobjTbl.setModel(nmVarmodel)

        nmVarmodel.addColumn("NIM");                // nmVarmodel.addColumn("judul kolom1")
        nmVarmodel.addColumn("Nama");               // nmVarmodel.addColumn("judul kolom2")
        nmVarmodel.addColumn("Jurusan");            // nmVarmodel.addColumn("judul kolom3")
        nmVarmodel.addColumn("Nilai");              // nmVarmodel.addColumn("judul kolom4")

        // Slide 9: memasukkan data ke JTable
        // Object[] nmVardata = new Object[jml.kolom];
        Object[] nmVardata = new Object[4];
        nmVardata[0] = "2024001";                   // nmVardata[0] = data1
        nmVardata[1] = "Budi Santoso";              // nmVardata[1] = data2
        nmVardata[2] = "Informatika";               // nmVardata[2] = data3
        nmVardata[3] = "85";                        // nmVardata[3] = data4
        nmVarmodel.addRow(nmVardata);               // nmVarmodel.addRow(nmVardata)

        // Slide 9: versi singkat
        Object[] nmVardata2 = {"2024002", "Siti Rahayu", "Sistem Informasi", "90"};
        nmVarmodel.addRow(nmVardata2);

        add(new JScrollPane(tblMahasiswa), BorderLayout.CENTER);
    }
}