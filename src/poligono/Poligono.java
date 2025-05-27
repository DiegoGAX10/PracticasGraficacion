package poligono;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Poligono extends JFrame {

    public Poligono() {
        setTitle("Polígono");
        setSize(700, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        int NL = 7;
        double ang = 0;
        double radioEx = 200;
        double radioInt = 100;
        double incremento = (Math.PI * 2) / NL;
        int[] puntosx1 = new int[NL];
        int[] puntosy1 = new int[NL];
        int[] puntosx2 = new int[NL];
        int[] puntosy2 = new int[NL];

        // Calcular las posiciones de los puntos
        for (int i = 0; i < NL; i++) {

            double xEx=300 + radioEx*Math.cos(ang);
            double yEx=300-radioEx*Math.sin(ang);
            puntosx1[i] = (int) xEx;
            puntosy1[i] = (int) yEx;
            double xInt = 300 + radioInt * Math.cos(ang);
            double yInt = 300 - radioInt * Math.sin(ang);
            puntosx2[i] = (int) xInt;
            puntosy2[i] = (int) yInt;

            ang+= incremento;
        }

        //DDA
        g.setColor(Color.RED);
        for (int i = 0; i < NL - 1; i++) {
            DDA(g, puntosx1[i], puntosy1[i], puntosx1[i + 1], puntosy1[i + 1]);}
        DDA(g, puntosx1[NL - 1], puntosy1[NL - 1], puntosx1[0], puntosy1[0]);

        // Bresenham
        g.setColor(Color.blue);
        for (int i = 0; i < NL - 1; i++) {
            Bresenham(g, puntosx2[i], puntosy2[i], puntosx2[i + 1], puntosy2[i + 1]);}
        Bresenham(g, puntosx2[NL - 1], puntosy2[NL - 1], puntosx2[0], puntosy2[0]);
    }

    private void DDA(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        float xInc = (float) dx / steps;
        float yInc = (float) dy / steps;
        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x), Math.round(y), 1, 1);
            x += xInc;
            y += yInc;
        }
    }
    private void Bresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawRect(x1, y1, 1, 1);
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x1 += sx; }
            if (e2 < dx) { err += dx; y1 += sy; }
        }
    }

    public static void main(String[] args) {
        new Poligono();
    }
}