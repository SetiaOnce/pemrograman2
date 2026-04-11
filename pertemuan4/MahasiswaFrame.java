// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MahasiswaFrame - Child Form / Sub-Frame
 *
 * Slide 16: Membuat sub-frame (child-form)
 * - Buat frame Internal: JInternalFrame Form
 * - Desain interface sesuai keperluan
 *
 * Slide 7 (Cara 2): Gunakan kode program untuk membentuk judul kolom
 * Slide 9: Memasukkan data ke JTable
 */
public class MahasiswaFrame extends JInternalFrame {

    // -----------------------------------------------
    // Slide 7 (Cara 2): Deklarasi var model table
    // private DefaultTableModel nmVarmodel;
    // -----------------------------------------------
    private DefaultTableModel model;

    private JTable tblMahasiswa;
    private JScrollPane scrollPane;

    // Input fields
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtJurusan;
    private JTextField txtNilai;

    private JButton btnTambah;
    private JButton btnHapus;
    private JButton btnBersih;

    public MahasiswaFrame() {
        initComponents();
    }

    private void initComponents() {
        // Setting JInternalFrame
        setTitle("Data Mahasiswa");
        setSize(650, 450);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setLocation(20, 20);

        setLayout(new BorderLayout(10, 10));

        // -----------------------------------------------
        // Slide 7 (Cara 2): Membentuk model dan kolom table via kode
        //
        // nmVarmodel = new DefaultTableModel();
        // namaVarobjTbl.setModel(nmVarmodel);
        // nmVarmodel.addColumn("judul kolom1");
        // nmVarmodel.addColumn("judul kolom2");
        // ...
        // -----------------------------------------------
        model = new DefaultTableModel();

        tblMahasiswa = new JTable();
        tblMahasiswa.setModel(model);         // namaVarobjTbl.setModel(nmVarmodel)

        model.addColumn("NIM");               // nmVarmodel.addColumn("judul kolom1")
        model.addColumn("Nama");              // nmVarmodel.addColumn("judul kolom2")
        model.addColumn("Jurusan");           // nmVarmodel.addColumn("judul kolom3")
        model.addColumn("Nilai");             // nmVarmodel.addColumn("judul kolom4")

        scrollPane = new JScrollPane(tblMahasiswa);
        add(scrollPane, BorderLayout.CENTER);

        // -----------------------------------------------
        // Panel input form
        // -----------------------------------------------
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 8, 8));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));

        panelInput.add(new JLabel("NIM :"));
        txtNim = new JTextField();
        panelInput.add(txtNim);

        panelInput.add(new JLabel("Nama :"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Jurusan :"));
        txtJurusan = new JTextField();
        panelInput.add(txtJurusan);

        panelInput.add(new JLabel("Nilai :"));
        txtNilai = new JTextField();
        panelInput.add(txtNilai);

        add(panelInput, BorderLayout.NORTH);

        // -----------------------------------------------
        // Panel tombol
        // -----------------------------------------------
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        btnTambah = new JButton("Tambah Data");
        btnHapus  = new JButton("Hapus Baris");
        btnBersih = new JButton("Bersih");

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData();
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusBaris();
            }
        });

        btnBersih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bersihInput();
            }
        });

        panelBtn.add(btnTambah);
        panelBtn.add(btnHapus);
        panelBtn.add(btnBersih);

        add(panelBtn, BorderLayout.SOUTH);
    }

    /**
     * Slide 9: Memasukkan data ke JTable
     *
     * Object[] nmVardata = new Object[jml.kolom]; // deklarasi var. data
     * nmVardata[0] = data1;
     * nmVardata[1] = data2;
     * nmVardata[2] = data3;
     * nmVardata[3] = data4;
     * nmVarmodel.addRow(nmVardata);
     *
     * ATAU versi singkat:
     * Object[] nmVardata = {data1, data2, data3, data4};
     */
    private void tambahData() {
        String nim     = txtNim.getText().trim();
        String nama    = txtNama.getText().trim();
        String jurusan = txtJurusan.getText().trim();
        String nilai   = txtNilai.getText().trim();

        if (nim.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM dan Nama tidak boleh kosong!");
            return;
        }

        // ------- Versi panjang (Slide 9 - baris per baris) -------
        Object[] nmVardata = new Object[4]; // deklarasi var. data (4 kolom)
        nmVardata[0] = nim;                 // nmVardata[0] = data1
        nmVardata[1] = nama;                // nmVardata[1] = data2
        nmVardata[2] = jurusan;             // nmVardata[2] = data3
        nmVardata[3] = nilai;               // nmVardata[3] = data4
        model.addRow(nmVardata);            // nmVarmodel.addRow(nmVardata)

        // ------- Versi singkat (Slide 9 - satu baris) -------
        // Object[] nmVardata = {nim, nama, jurusan, nilai};
        // model.addRow(nmVardata);

        bersihInput();
    }

    private void hapusBaris() {
        int selectedRow = tblMahasiswa.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
        }
    }

    private void bersihInput() {
        txtNim.setText("");
        txtNama.setText("");
        txtJurusan.setText("");
        txtNilai.setText("");
        txtNim.requestFocus();
    }
}