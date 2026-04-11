// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainFrame - Parent Form / MDI Form
 * 
 * Slide 13-15: Membuat menu utama (parent-form)
 * - Tambahkan menu bar (Menu-menu pada menu bar)
 * - Pada Frame: tambahkan Desktop Panel (JDesktopPane)
 */
public class MainFrame extends JFrame {

    // JDesktopPane sebagai container untuk child frame (JInternalFrame)
    private JDesktopPane desktopPane;

    // Menu Bar dan menu-menu di dalamnya
    private JMenuBar menuBar;
    private JMenu menuData;
    private JMenuItem menuItemMahasiswa;
    private JMenuItem menuItemKeluar;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // Setting judul dan ukuran frame
        setTitle("Aplikasi Menu Utama - Pemrograman 2");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // -----------------------------------------------
        // Slide 14: Tambahkan Desktop Panel (JDesktopPane)
        // -----------------------------------------------
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(230, 230, 230));
        add(desktopPane, BorderLayout.CENTER);

        // -----------------------------------------------
        // Slide 14: Tambahkan menu bar
        // -----------------------------------------------
        menuBar = new JMenuBar();

        menuData = new JMenu("Data");

        menuItemMahasiswa = new JMenuItem("Data Mahasiswa");
        menuItemKeluar    = new JMenuItem("Keluar");

        // Slide 17: Memanggil antar Frame (JInternalFrame)
        // new namaClassFrame().setVisible(true); --> versi JInternalFrame: add ke desktopPane
        menuItemMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bukaChildFrame();
            }
        });

        menuItemKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuData.add(menuItemMahasiswa);
        menuData.addSeparator();
        menuData.add(menuItemKeluar);
        menuBar.add(menuData);

        setJMenuBar(menuBar);
    }

    /**
     * Slide 17: Cara memanggil/menampilkan frame (JInternalFrame)
     * Versi JInternalFrame: tambahkan ke desktopPane lalu setVisible(true)
     */
    private void bukaChildFrame() {
        MahasiswaFrame childFrame = new MahasiswaFrame();
        desktopPane.add(childFrame);
        childFrame.setVisible(true); // new namaClassFrame().setVisible(true)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}