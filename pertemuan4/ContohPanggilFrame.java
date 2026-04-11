// NAMA    : I GEDE YOGA SETIAWAN
// NIM     : 231011401028
// KELAS   : 06TPLE016

public class ContohPanggilFrame {

    public static void main(String[] args) {

        // Slide 17: Cara memanggil antar Frame (JFrame Form)

        // Versi 1:
        new MainFrame().setVisible(true);

        // Versi 2:
        // namaClassFrame namaVar = new namaClassFrame();
        // namaVar.setVisible(true);
        MainFrame namaVar = new MainFrame();
        namaVar.setVisible(true);
    }
}