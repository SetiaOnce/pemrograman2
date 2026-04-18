// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormGaji extends JFrame {
    
    private final GajiController gajiController = new GajiController();
    
    // Deklarasi Komponen
    private JTextField ktpTextField;
    private JTextField namaKaryawanTextField;
    private JTextField kodePekerjaanTextField;
    private JTextField namaPekerjaanTextField;
    private JButton simpanButton;
    private JButton lihatButton;

    public FormGaji() {
        setTitle("Transaksi Mengelola Gaji");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 255, 204));
        panel.setBounds(10, 10, 380, 150);
        panel.setLayout(null);
        add(panel);

        // KTP Karyawan
        JLabel lblKtp = new JLabel("KTP");
        lblKtp.setBounds(20, 20, 100, 25);
        panel.add(lblKtp);
        
        ktpTextField = new JTextField();
        ktpTextField.setBounds(120, 20, 100, 25);
        panel.add(ktpTextField);

        // Nama Karyawan (Read-Only)
        namaKaryawanTextField = new JTextField();
        namaKaryawanTextField.setBounds(230, 20, 130, 25);
        namaKaryawanTextField.setEditable(false);
        namaKaryawanTextField.setBackground(Color.LIGHT_GRAY);
        panel.add(namaKaryawanTextField);

        // Kode Pekerjaan
        JLabel lblKode = new JLabel("Kode Pekerjaan");
        lblKode.setBounds(20, 60, 100, 25);
        panel.add(lblKode);
        
        kodePekerjaanTextField = new JTextField();
        kodePekerjaanTextField.setBounds(120, 60, 100, 25);
        panel.add(kodePekerjaanTextField);

        // Nama Pekerjaan (Read-Only)
        namaPekerjaanTextField = new JTextField();
        namaPekerjaanTextField.setBounds(230, 60, 130, 25);
        namaPekerjaanTextField.setEditable(false);
        namaPekerjaanTextField.setBackground(Color.LIGHT_GRAY);
        panel.add(namaPekerjaanTextField);

        // Tombol Simpan & Lihat
        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(100, 180, 100, 30);
        add(simpanButton);

        lihatButton = new JButton("Lihat Data");
        lihatButton.setBounds(220, 180, 100, 30);
        add(lihatButton);

        // --- EVENT LISTENER ---

        // Cari Karyawan otomatis saat KTP di-Enter
        ktpTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    gajiController.cariKaryawan(ktpTextField, namaKaryawanTextField);
                    kodePekerjaanTextField.requestFocus(); // Otomatis pindah kursor ke kolom kode
                }
            }
        });

        // Cari Pekerjaan otomatis saat Kode di-Enter
        kodePekerjaanTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    gajiController.cariPekerjaan(kodePekerjaanTextField, namaPekerjaanTextField);
                }
            }
        });

        // Simpan Transaksi
        simpanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Pastikan nama tidak kosong (artinya data valid)
                if (namaKaryawanTextField.getText().isEmpty() || namaPekerjaanTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pastikan KTP dan Kode Pekerjaan valid (Tekan Enter di setiap kolom)!");
                } else {
                    gajiController.simpan(ktpTextField, kodePekerjaanTextField);
                }
            }
        });

        // Lihat Daftar Transaksi
        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gajiController.tampilkanDaftar();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormGaji().setVisible(true);
        });
    }
}