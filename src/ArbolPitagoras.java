import javax.swing.*;
import java.awt.*;

public class ArbolPitagoras extends JFrame {
    public ArbolPitagoras() {
        setTitle("Fractal de Árbol");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        drawTree(g, 400, 500, -90, 100, 10);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int length, int depth) {
        if (depth == 0) return;

        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * length);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * length);

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 30, length * 2 / 3, depth - 1);
        drawTree(g, x2, y2, angle + 30, length * 2 / 3, depth - 1);
    }

    public static void main(String[] args) {
        new ArbolPitagoras();
    }
}