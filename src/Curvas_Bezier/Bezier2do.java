package Curvas_Bezier;

import javax.swing.*;
import java.awt.*;

public class Bezier2do extends JFrame {
    private final int[][] puntosDeControl = {
            {0, 0}, {3, 4}, {9, -4}
    };

    public Bezier2do() {
        setTitle("Curva de Bézier 2do Orden");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        printBezierTable();
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
            t = i / (double) seg;
            int x = (int) ((Math.pow(1 - t, 2) * puntosDeControl[0][0] +
                    2 * (1 - t) * t * puntosDeControl[1][0] +
                    Math.pow(t, 2) * puntosDeControl[2][0]) * 50 + 300);

            int y = (int) ((Math.pow(1 - t, 2) * puntosDeControl[0][1] +
                    2 * (1 - t) * t * puntosDeControl[1][1] +
                    Math.pow(t, 2) * puntosDeControl[2][1]) * -50 + 300);

            g.drawLine(xAnterior, yAnterior, x, y);
            xAnterior = x;
            yAnterior = y;
        }
        g.setColor(Color.red);
        for (int i = 0; i < 3; i++) {
            g.fillOval(puntosDeControl[i][0] * 50 + 300 - 5, -puntosDeControl[i][1] * 50 + 300 - 5, 10, 10);
        }
    }

    private void printBezierTable() {
        int seg = 10;
        double t;
        System.out.println("t\tx\ty");
        for (int i = 0; i <= seg; i++) {
            t = i / (double) seg;
            int x = (int) ((Math.pow(1 - t, 2) * puntosDeControl[0][0] +
                    2 * (1 - t) * t * puntosDeControl[1][0] +
                    Math.pow(t, 2) * puntosDeControl[2][0]) * 50 + 300);

            int y = (int) ((Math.pow(1 - t, 2) * puntosDeControl[0][1] +
                    2 * (1 - t) * t * puntosDeControl[1][1] +
                    Math.pow(t, 2) * puntosDeControl[2][1]) * -50 + 300);

            System.out.printf("%.2f\t%d\t%d%n", t, x, y);
        }
    }

    public static void main(String[] args) {
        new Bezier2do();
    }
}