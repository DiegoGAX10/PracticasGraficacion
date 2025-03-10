import javax.swing.*;
import java.awt.*;

public class CantorFractal extends JFrame {
    private int depth;

    public CantorFractal(int depth) {
        this.depth = depth;
        setTitle("Fractal de Cantor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void drawCantor(Graphics g, int x, int y, int length, int depth) {
        if (depth == 0) return;
        g.fillRect(x, y, length, 10);
        int newY = y + 20;
        drawCantor(g, x, newY, length / 3, depth - 1);
        drawCantor(g, x + 2 * length / 3, newY, length / 3, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        drawCantor(g, 50, 50, 500, depth);
    }

    public static void main(String[] args) {
        new CantorFractal(6);
    }
}