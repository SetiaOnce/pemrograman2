// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormLogin extends JFrame {
    
    private final LoginController loginController = new LoginController();
    private String userLogin = ""; // Variabel penampung user yang sukses login
    
    // Deklarasi Komponen
    private JTextField userIdTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton batalButton;

    public FormLogin() {
        setTitle("Form Login");
        setSize(360, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Agar form muncul di tengah layar
        setLayout(null);
        
        // Warna latar belakang abu-abu terang meniru desain form login standar
        getContentPane().setBackground(new Color(235, 235, 235));

        // Label dan Input User ID (KTP)
        JLabel lblUserId = new JLabel("User ID (KTP)");
        lblUserId.setBounds(40, 30, 100, 25);
        add(lblUserId);
        
        userIdTextField = new JTextField();
        userIdTextField.setBounds(140, 30, 160, 25);
        add(userIdTextField);

        // Label dan Input Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 70, 100, 25);
        add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 70, 160, 25);
        add(passwordField);

        // Tombol Login
        loginButton = new JButton("Login");
        loginButton.setBounds(60, 130, 90, 30);
        add(loginButton);

        // Tombol Batal
        batalButton = new JButton("Batal");
        batalButton.setBounds(190, 130, 90, 30);
        add(batalButton);

        // --- EVENT LISTENER ---

        // 1. Event Window Activated (Mengosongkan user login saat form terbuka)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                userLogin = "";
            }
        });

        // 2. Event Tombol Login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Memanggil fungsi validasi dari controller
                if (loginController.validasi(userIdTextField, passwordField)) {
                    // Jika sukses, simpan KTP ke variabel dan kosongkan field
                    userLogin = userIdTextField.getText();
                    userIdTextField.setText("");
                    passwordField.setText("");
                    
                    // Tutup jendela Form Login ini
                    dispose(); 
                }
            }
        });

        // 3. Event Tombol Batal
        batalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Mematikan seluruh program jika batal
                System.exit(0); 
            }
        });
    }

    // Fungsi getter untuk dibutuhkan oleh Form Utama nantinya
    public String getUserLogin() {
        return userLogin;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }
}