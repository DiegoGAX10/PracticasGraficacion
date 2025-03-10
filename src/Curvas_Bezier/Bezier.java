package Curvas_Bezier;

import javax.swing.*;
import java.awt.*;

public class Bezier extends JFrame {
    private final int[][] puntosDeControl = {
            {0, 0}, {3, 4}, {9, -4}, {10, 2}
    };

    public Bezier() {
        setTitle("Curva de Bézier");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        drawBezier(g);
    }

    private void drawBezier(Graphics g) {
        int seg = 100; // Número de segmentos para suavizar la curva
        double t;
        int xAnterior = puntosDeControl[0][0] * 50 + 300;
        int yAnterior = -puntosDeControl[0][1] * 50 + 300;

        for (int i = 1; i <= seg; i++) {
            t = i / (double) seg;
            int x = (int) ((Math.pow(1 - t, 3) * puntosDeControl[0][0] +
                    3 * Math.pow(1 - t, 2) * t * puntosDeControl[1][0] +
                    3 * (1 - t) * Math.pow(t, 2) * puntosDeControl[2][0] +
                    Math.pow(t, 3) * puntosDeControl[3][0]) * 50 + 300);

            int y = (int) ((Math.pow(1 - t, 3) * puntosDeControl[0][1] +
                    3 * Math.pow(1 - t, 2) * t * puntosDeControl[1][1] +
                    3 * (1 - t) * Math.pow(t, 2) * puntosDeControl[2][1] +
                    Math.pow(t, 3) * puntosDeControl[3][1]) * -50 + 300);

            g.drawLine(xAnterior, yAnterior, x, y);
            xAnterior = x;
            yAnterior = y;
        }

        // Dibujar los puntos de control
        g.setColor(Color.red);
        for (int[] punto : puntosDeControl) {
            int px = punto[0] * 50 + 300;
            int py = -punto[1] * 50 + 300;
            g.fillOval(px - 3, py - 3, 6, 6);
        }
    }

    public static void main(String[] args) {
        new Bezier();
    }
}