import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GK0122_Tatasurya extends JPanel {
    // diketahui
    int radiusOrbit = 200;
    int jumlahPutar = 365;
    double angleOrbit = 0; // Sudut rotasi orbit
    double anglePlanet = 0; // Sudut rotasi planet
    int RLingkaran = 10;
    int RSun = RLingkaran * 3;

    public GK0122_Tatasurya() {
        setBackground(Color.white); // Warna latar belakang
        Timer timer = new Timer(25, e -> {
            angleOrbit += Math.toRadians(1); // Perubahan sudut rotasi orbit
            anglePlanet += Math.toRadians(1) * jumlahPutar * 75; // Perubahan sudut rotasi planet
            repaint(); // Memanggil paintComponent setiap kali timer dipicu
        });
        timer.start(); // Mulai timer
    }

    @Override
    public void paintComponent(Graphics f) {
        int kali = 1;
        int radius = 10 * kali;
        int rTitik = 3 * kali;

        super.paintComponent(f);
        Graphics2D g2d = (Graphics2D) f;
        g2d.drawString("Exercise 2.2", 50, 120);

        g2d.drawString("Evi Fitriya / 1201222005", 50, 150);
        // draw sun
        g2d.setColor(Color.ORANGE);
        g2d.fill(new Ellipse2D.Double(getWidth() / 2 - RSun, getHeight() / 2 - RSun, RSun * 2, RSun * 2));

        // kalkulasi posisi planet
        double theX = getWidth() / 2 + radiusOrbit * Math.cos(angleOrbit);
        double theY = getHeight() / 2 + radiusOrbit * Math.sin(angleOrbit);

        // the planet
        g2d.setColor(Color.black);
        g2d.rotate(anglePlanet, theX, theY); // Rotasi planet pada sumbunya
        g2d.fillOval((int) theX - radius, (int) theY - radius, radius * 2, radius * 2);
        g2d.rotate(-anglePlanet, theX, theY); // Kembalikan rotasi

        // the titik di planet
        g2d.setColor(Color.white);
        double titikX = theX + radius * Math.cos(anglePlanet); // Gunakan anglePlanet untuk menentukan posisi titik
        double titikY = theY + radius * Math.sin(anglePlanet);
        g2d.fillOval((int) (titikX - rTitik / 2), (int) (titikY - rTitik / 2), rTitik, rTitik);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tata Surya");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 300);
        frame.getContentPane().add(new GK0122_Tatasurya());
        frame.pack();
        frame.setLocationRelativeTo(null); // Posisi frame di tengah layar
        frame.setVisible(true);
    }

}
