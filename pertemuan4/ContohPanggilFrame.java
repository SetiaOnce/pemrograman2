// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

/**
 * ContohPanggilFrame
 *
 * Slide 17: Cara memanggil/menampilkan frame
 *
 * 1. Memanggil antar Frame (JFrame Form)
 *    new namaClassFrame().setVisible(true);
 *
 *    ATAU
 *
 *    namaClassFrame namaVar = new namaClassFrame();
 *    namaVar.setVisible(true);
 */
public class ContohPanggilFrame {

    public static void contohCaraPanggilFrame() {

        // --------------------------------------------------
        // Cara memanggil Frame - Versi 1 (langsung)
        // new namaClassFrame().setVisible(true);
        // --------------------------------------------------
        new MainFrame().setVisible(true);

        // --------------------------------------------------
        // Cara memanggil Frame - Versi 2 (pakai variabel)
        // namaClassFrame namaVar = new namaClassFrame();
        // namaVar.setVisible(true);
        // --------------------------------------------------
        MainFrame namaVar = new MainFrame();
        namaVar.setVisible(true);
    }
}