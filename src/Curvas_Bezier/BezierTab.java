package Curvas_Bezier;

import javax.swing.*;
import java.awt.*;

public class BezierTab extends JFrame {
    private final int[][] puntosDeControl = {
            {0, 34}, {0, 51}, {9, 18}, {1, 1}
    };

    public BezierTab() {
        int seg = 10;
        double t;
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

            System.out.println("x: " + x + " y: " + y);
        }
    }

    public static void main(String[] args) {
        new BezierTab();
    }
}