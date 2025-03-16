package Curvas_Bezier;

public class BezierTab {
    double[][] puntosDeControl = {
            {1, 1},
            {4, 7},
            {7, -4},
            {10, 2}
    };

    public BezierTab() {
        double t;
        System.out.println("t\t x'\t y'");
        for (int i = 0; i <= 10; i++) {
            t = i / 10.0;
            double x = Math.pow(1 - t, 3) * puntosDeControl[0][0] +
                    3 * Math.pow(1 - t, 2) * t * puntosDeControl[1][0] +
                    3 * (1 - t) * Math.pow(t, 2) * puntosDeControl[2][0] +
                    Math.pow(t, 3) * puntosDeControl[3][0];

            double y = Math.pow(1 - t, 3) * puntosDeControl[0][1] +
                    3 * Math.pow(1 - t, 2) * t * puntosDeControl[1][1] +
                    3 * (1 - t) * Math.pow(t, 2) * puntosDeControl[2][1] +
                    Math.pow(t, 3) * puntosDeControl[3][1];

            System.out.printf("%.1f\t %.2f\t %.2f%n", t, x, y);
        }
    }

    public static void main(String[] args) {
        new BezierTab();
    }
}
