package Fractales;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DragonFractal extends JFrame {
    private int depth;

    public DragonFractal(int depth) {
        this.depth = depth;
        setTitle("Fractal del Dragón");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void drawDragon(Graphics2D g, double x1, double y1, double x2, double y2, int depth, boolean left) {
        if (depth == 0) {
            g.draw(new Line2D.Double(x1, y1, x2, y2));
        } else {
            double midX = (x1 + x2) / 2;
            double midY = (y1 + y2) / 2;
            double dx = x2 - x1;
            double dy = y2 - y1;
            double newX = midX + (left ? -dy : dy) / 2;
            double newY = midY + (left ? dx : -dx) / 2;

            drawDragon(g, x1, y1, newX, newY, depth - 1, true);
            drawDragon(g, x2, y2, newX, newY, depth - 1, false);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        drawDragon(g2d, 100, 300, 500, 300, depth, true);
    }

    public static void main(String[] args) {
        new DragonFractal(12);
    }
}