package Curvas_Bezier;

import javax.swing.*;
import java.awt.*;

public class Bezier3er extends JFrame {
    private final int[][] puntosDeControl = {
            {0, 0}, {3, 4}, {9, -4}, {10, 2}
    };

    public Bezier3er() {
        setTitle("Curva de Bézier 3er Orden");
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
        int seg = 100;
        double t;
        int xAnterior = puntosDeControl[0][0] * 50 + 300;
        int yAnterior = -puntosDeControl[0][1] * 50 + 300;

        for (int i = 1; i <= seg; i++) {
            t = i /  (double) seg;
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
        g.setColor(Color.red);
        for (int i = 0; i < 4; i++) {
            g.fillOval(puntosDeControl[i][0] * 50 + 300 - 5, -puntosDeControl[i][1] * 50 + 300 - 5, 10, 10);
        }
    }

    public static void main(String[] args) {
        new Bezier3er();
    }
}