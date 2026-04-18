// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPekerjaan extends JFrame {
    
    // Deklarasi object controller
    private final PekerjaanController pekerjaanController = new PekerjaanController();
    
    // Deklarasi Komponen GUI
    private JTextField kodePekerjaanTextField;
    private JTextField namaPekerjaanTextField;
    private JComboBox<String> jumlahTugasComboBox;
    private JButton simpanButton;
    private JButton hapusButton;
    private JButton lihatButton;

    public FormPekerjaan() {
        setTitle("Master Data Pekerjaan");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Bisa diganti DISPOSE_ON_CLOSE jika nanti digabung ke FormUtama
        setLocationRelativeTo(null);
        setLayout(null); 

        // Panel Latar Belakang (Warna hijau tosca)
        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 255, 204));
        panel.setBounds(10, 10, 360, 140);
        panel.setLayout(null);
        add(panel);

        // Label dan Input Kode Pekerjaan
        JLabel lblKode = new JLabel("Kode Pekerjaan");
        lblKode.setBounds(20, 20, 100, 25);
        panel.add(lblKode);
        
        kodePekerjaanTextField = new JTextField();
        kodePekerjaanTextField.setBounds(120, 20, 120, 25);
        panel.add(kodePekerjaanTextField);

        lihatButton = new JButton("Lihat");
        lihatButton.setBounds(250, 20, 80, 25);
        panel.add(lihatButton);

        // Label dan Input Nama Pekerjaan
        JLabel lblNama = new JLabel("Nama Pekerjaan");
        lblNama.setBounds(20, 60, 100, 25);
        panel.add(lblNama);
        
        namaPekerjaanTextField = new JTextField();
        namaPekerjaanTextField.setBounds(120, 60, 210, 25);
        panel.add(namaPekerjaanTextField);

        // Label dan Input Jumlah Tugas
        JLabel lblTugas = new JLabel("Jumlah Tugas");
        lblTugas.setBounds(20, 100, 100, 25);
        panel.add(lblTugas);
        
        String[] tugasOptions = {"1", "2", "3", "4", "5"}; // Pilihan dummy sesuai modul
        jumlahTugasComboBox = new JComboBox<>(tugasOptions);
        jumlahTugasComboBox.setBounds(120, 100, 80, 25);
        panel.add(jumlahTugasComboBox);

        // Tombol Simpan
        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(100, 170, 100, 30);
        add(simpanButton);

        // Tombol Hapus
        hapusButton = new JButton("Hapus");
        hapusButton.setBounds(220, 170, 100, 30);
        add(hapusButton);

        // --- EVENT LISTENER ---

        // 1. Event Simpan Button (Action Performed)
        simpanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pekerjaanController.simpan(kodePekerjaanTextField, namaPekerjaanTextField, jumlahTugasComboBox);
            }
        });

        // 2. Event Hapus Button (Action Performed)
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pekerjaanController.hapus(kodePekerjaanTextField);
            }
        });

        // 3. Event Lihat Button (Action Performed)
        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pekerjaanController.tampilkanDaftar();
            }
        });

        // 4. Event Cari via Kode Enter (Key Pressed)
        kodePekerjaanTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    pekerjaanController.cari(kodePekerjaanTextField, namaPekerjaanTextField, jumlahTugasComboBox);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi FormPekerjaan
        SwingUtilities.invokeLater(() -> {
            new FormPekerjaan().setVisible(true);
        });
    }
}