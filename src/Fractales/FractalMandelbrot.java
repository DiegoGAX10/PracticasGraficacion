package Fractales;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FractalMandelbrot extends JPanel {

    // Definir las dimensiones de la ventana y la imagen
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    // Parámetros del conjunto de Mandelbrot
    private static final int MAX_ITER = 1000;  // Número máximo de iteraciones
    private static final double ZOOM = 200;    // Zoom de la imagen

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Crear una imagen en memoria
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // Recorremos todos los píxeles de la imagen
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                // Convertir las coordenadas (x, y) a valores del plano complejo
                double zx = 1.5 * (x - WIDTH / 2) / ZOOM;
                double zy = (y - HEIGHT / 2) / ZOOM;
                int i = mandelbrot(zx, zy);

                // Asignar un color según el número de iteraciones
                int color = i | (i << 8);
                image.setRGB(x, y, color);
            }
        }

        // Dibujar la imagen en el panel
        g.drawImage(image, 0, 0, null);
    }

    // Método que calcula el número de iteraciones para un punto (c) en el conjunto de Mandelbrot
    private int mandelbrot(double zx, double zy) {
        double cX = zx;
        double cY = zy;
        int iter = 0;

        // Iterar hasta que el valor de z se aleje demasiado o se alcance el número máximo de iteraciones
        while (zx * zx + zy * zy < 4 && iter < MAX_ITER) {
            double temp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = temp;
            iter++;
        }

        return iter;
    }

    public static void main(String[] args) {
        // Crear la ventana de JFrame
        JFrame frame = new JFrame("Conjunto de Mandelbrot");
        FractalMandelbrot panel = new FractalMandelbrot();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
