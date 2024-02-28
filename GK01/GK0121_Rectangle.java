
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GK0121_Rectangle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // define Graphics2D untuk menggambar 2 dimensi
        Graphics2D g2d = (Graphics2D) g;

        // Membuat GeneralPath untuk persegi panjang dengan sudut yang dibulatkan
        GeneralPath gp = new GeneralPath();

        // soal
        g2d.drawString("Exercise 2.1", 50, 10);
        g2d.drawString("Use a GeneralPath to draw a rectangle with rounded corners.", 50, 30);

        float x = 50;
        float y = 50;
        float lb = 200;
        ////////////
        // titik awal garis
        float pA = 50 + x;
        gp.moveTo(pA + 17, y);
        // garis atas
        gp.lineTo(x + lb, y);
        // menyambungkan garis atas ke garis kanan
        gp.quadTo(x + lb + 17, y + 5, x + lb + 17, y + 20);
        // garis kanan
        gp.lineTo(x + lb + 17, y + 20 + 40);
        // menyambungkan garis kanan ke garis bawah
        gp.quadTo(x + lb + 17, y + 20 + 40 + 17, x + lb, y + 20 + 40 + 20);
        // garis bawah
        gp.lineTo(pA + 17, y + 20 + 40 + 20);
        // menyambungkan garis bawah ke garis kiri
        gp.quadTo(pA + 3, y + 20 + 40 + 17, pA, y + 20 + 40);
        // garis kiri
        gp.lineTo(pA, y + 20);
        // menyambungkan garis kiri ke garis atas
        gp.quadTo(pA + 5, y + 3, pA + 17, y);

        // Nama Saya
        g2d.drawString("Evi Fitriya / 1201222005", 50, 150);
        g2d.draw(gp);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exercise 2.1");

            // template for run
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 300);
            frame.add(new GK0121_Rectangle());
            /* (wajib) untuk memunculkan pop up layar */ frame.setVisible(true);
        });
    }
}
