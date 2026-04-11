// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu menuData;
    private JMenuItem menuItemMahasiswa;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Utama");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Slide 14: tambahkan Desktop Panel (JDesktopPane)
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        // Slide 14: tambahkan menu bar
        menuBar       = new JMenuBar();
        menuData      = new JMenu("Data");
        menuItemMahasiswa = new JMenuItem("Data Mahasiswa");

        // Slide 17: memanggil/menampilkan frame
        menuItemMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new namaClassFrame().setVisible(true);
                MahasiswaFrame childFrame = new MahasiswaFrame();
                desktopPane.add(childFrame);
                childFrame.setVisible(true);
            }
        });

        menuData.add(menuItemMahasiswa);
        menuBar.add(menuData);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}