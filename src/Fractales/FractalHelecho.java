package Fractales;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FractalHelecho extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public FractalHelecho() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Crear un objeto de Graphics2D para una mejor calidad de gráficos
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);  // Color del fractal de helecho

        // Parámetros del fractal
        double x = 0, y = 0;
        Random rand = new Random();

        // Iterar un número de veces para generar el fractal
        for (int i = 0; i < 100000; i++) {
            double r = rand.nextDouble();

            double x_new, y_new;

            // Escoger una de las transformaciones de acuerdo al valor aleatorio
            if (r < 0.01) {
                x_new = 0;
                y_new = 0.16 * y;
            } else if (r < 0.86) {
                x_new = 0.85 * x + 0.04 * y;
                y_new = -0.04 * x + 0.85 * y + 1.6;
            } else if (r < 0.93) {
                x_new = 0.2 * x - 0.26 * y;
                y_new = 0.23 * x + 0.22 * y + 1.6;
            } else {
                x_new = -0.15 * x + 0.28 * y;
                y_new = 0.26 * x + 0.24 * y + 0.44;
            }

            x = x_new;
            y = y_new;

            // Escalar y dibujar el punto en el panel
            int px = (int) (WIDTH / 2 + x * 100);
            int py = (int) (HEIGHT - y * 100);

            g2d.fillRect(px, py, 1, 1);
        }
    }

    public static void main(String[] args) {
        // Crear ventana de JFrame
        JFrame frame = new JFrame("Fractal de Helecho");
        FractalHelecho panel = new FractalHelecho();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
