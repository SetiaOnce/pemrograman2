// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormKaryawan extends JFrame {
    // Sesuai dengan instruksi PDF, kita deklarasikan controller
    private final KaryawanController karyawanController = new KaryawanController();
    
    // Deklarasi Komponen GUI
    private JTextField ktpTextField;
    private JTextField namaTextField;
    private JComboBox<String> ruangComboBox;
    private JPasswordField passwordField;
    private JButton simpanButton;
    private JButton hapusButton;
    private JButton lihatButton;

    public FormKaryawan() {
        setTitle("Master Data Karyawan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 255, 204));
        panel.setBounds(10, 10, 360, 180);
        panel.setLayout(null);
        add(panel);

        // Label dan Input KTP
        JLabel lblKtp = new JLabel("KTP");
        lblKtp.setBounds(20, 20, 80, 25);
        panel.add(lblKtp);
        
        ktpTextField = new JTextField();
        ktpTextField.setBounds(100, 20, 150, 25);
        panel.add(ktpTextField);

        lihatButton = new JButton("Lihat");
        lihatButton.setBounds(260, 20, 80, 25);
        panel.add(lihatButton);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 60, 80, 25);
        panel.add(lblNama);
        
        namaTextField = new JTextField();
        namaTextField.setBounds(100, 60, 150, 25);
        panel.add(namaTextField);

        JLabel lblRuang = new JLabel("Ruang");
        lblRuang.setBounds(20, 100, 80, 25);
        panel.add(lblRuang);
        
        String[] ruangOptions = {"1", "2", "3", "4"};
        ruangComboBox = new JComboBox<>(ruangOptions);
        ruangComboBox.setBounds(100, 100, 80, 25);
        panel.add(ruangComboBox);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(20, 140, 80, 25);
        panel.add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 140, 150, 25);
        panel.add(passwordField);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(100, 210, 100, 30);
        add(simpanButton);

        hapusButton = new JButton("Hapus");
        hapusButton.setBounds(220, 210, 100, 30);
        add(hapusButton);


        simpanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                karyawanController.simpan(ktpTextField, namaTextField, ruangComboBox, passwordField);
            }
        });


        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                karyawanController.hapus(ktpTextField);
            }
        });

        ktpTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    karyawanController.cari(ktpTextField, namaTextField, ruangComboBox);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> {
            new FormKaryawan().setVisible(true);
        });
    }
}