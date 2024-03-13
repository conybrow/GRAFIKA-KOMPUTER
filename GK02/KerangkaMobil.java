package GK02;

import java.awt.*;
import java.awt.geom.*;

public class KerangkaMobil extends Frame {
  // Konstruktor
  KerangkaMobil() {
    // Mengaktifkan penutupan jendela.
    addWindowListener(new MyFinishWindow());
  }

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    g2d.drawString("Evi Fitriya / 1201222005 / GK02", 50, 180);
    // Mengatur hint rendering untuk membuat gambar lebih halus.
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Mengatur pola garis putus-putus.
    Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
    g2d.setStroke(dashed);

    // Membuat objek GeneralPath.
    GeneralPath gp = new GeneralPath();

    // Mulai di depan bawah mobil.
    gp.moveTo(60, 120);
    // bawah depan
    gp.lineTo(80, 120);
    // Roda depan
    gp.quadTo(90, 140, 100, 120);
    // bawah tengah
    gp.lineTo(160, 120);
    // Roda belakang
    gp.quadTo(170, 140, 180, 120);
    // bawah belakang
    gp.lineTo(200, 120);
    // Belakang
    gp.curveTo(195, 100, 200, 80, 160, 80);
    // Atap
    gp.lineTo(110, 80);
    // Kaca depan
    gp.lineTo(90, 100);
    // Kap depan
    gp.lineTo(60, 100);
    // Depan
    gp.lineTo(60, 120);

    // Menggambar mobil.
    g2d.draw(gp);

    Graphics2D gd = (Graphics2D) g;

    // Mengatur hint rendering untuk membuat garis lebih halus.
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Mengatur stroke dasar.
    BasicStroke bs = new BasicStroke(3.0f);
    gd.setStroke(bs);
    // Menggambar sistem koordinat.
    drawSimpleCoordinateSystem(200, 150, gd);
  }

  // Metode untuk menggambar sistem koordinat sederhana.
  public static void drawSimpleCoordinateSystem(int xmax, int ymax, Graphics2D g2d) {
    int xOffset = 30;
    int yOffset = 50;
    int step = 20;
    String s;
    // Mengingat font asli.
    Font fo = g2d.getFont();
    // Menggunakan font kecil.
    g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
    // sumbu x.
    g2d.drawLine(xOffset, yOffset, xmax, yOffset);
    // Tanda dan label untuk sumbu x.
    for (int i = xOffset + step; i <= xmax; i = i + step) {
      g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
      g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
    }

    // sumbu y.
    g2d.drawLine(xOffset, yOffset, xOffset, ymax);

    // Tanda dan label untuk sumbu y.
    s = "  "; // untuk indentasi angka < 100
    for (int i = yOffset + step; i <= ymax; i = i + step) {
      g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
      if (i > 99) {
        s = "";
      }
      g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
    }

    // Mengembalikan font asli.
    g2d.setFont(fo);
  }

  // Metode utama program.
  public static void main(String[] argv) {
    KerangkaMobil f = new KerangkaMobil();
    f.setTitle("Kerangka Mobil");
    f.setSize(250, 200);
    f.setVisible(true);
  }
}
