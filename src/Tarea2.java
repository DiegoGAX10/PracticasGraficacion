import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class Tarea2 extends JFrame {
    public Tarea2() {
        setTitle("Dibujo de una cara con montañas");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(135, 206, 250));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(34, 139, 34));
        int[] x1 = {0, 150, 300, 0};
        int[] y1 = {600, 300, 600, 600};
        g.fillPolygon(x1, y1, 4);
        int[] x2 = {300, 450, 600, 300};
        int[] y2 = {600, 400, 600, 600};
        g.fillPolygon(x2, y2, 4);
        g.setColor(Color.YELLOW);
        g.fillOval(150, 100, 300, 300);
        g.setColor(Color.BLACK);
        g.fillOval(220, 180, 50, 50);
        g.fillOval(330, 180, 50, 50);
        g.setColor(Color.RED);
        g.drawArc(220, 250, 160, 100, 0, -180);
        g.setColor(Color.BLACK);
        g.fillRect(285, 280, 30, 10);
        g.setColor(Color.ORANGE);
        g.fillRect(500, 0, 110, 100);
    }

    public static void main(String[] args) {
        Tarea2 ventana = new Tarea2();
    }
}