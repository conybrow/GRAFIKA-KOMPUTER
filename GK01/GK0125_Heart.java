import javax.swing.*;
import java.awt.*;

public class GK0125_Heart extends JPanel implements Runnable {
    private int tinggi = 600;
    private int besarBox = 50;

    private int pjgGaris = 600;
    private int vBox = 2;

    private int theX;
    private boolean moveRight;

    public GK0125_Heart() {
        theX = 0;
        moveRight = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Exercise 2.5", 50, 120);

        g2d.drawString("Evi Fitriya / 1201222005", 50, 150);

        // Draw the line
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, tinggi / 2, tinggi, tinggi / 2);

        // Draw the box
        g2d.setColor(Color.BLUE);
        g2d.fillRect(theX, tinggi / 2 - besarBox / 2, besarBox, besarBox);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override

    public void run() {
        while (true) {
            if (moveRight) {
                theX += vBox;
                if (theX >= pjgGaris - besarBox) {
                    moveRight = false;
                }
            } else {
                theX -= vBox;
                if (theX <= 0) {
                    moveRight = true;
                }
            }

            repaint();

            try {
                // kecepatan
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maaf bu menggambar hatinya, saya belum bisa");
        GK0125_Heart animation = new GK0125_Heart();
        frame.add(animation);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread thread = new Thread(animation);
        thread.start();
    }
}
