import javax.swing.*;
import java.awt.*;

public class FractalSierpinski extends JPanel {

    // Definir el tamaño de la ventana
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    // Método recursivo para dibujar el triángulo de Sierpinski
    private void dibujarTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int profundidad) {
        if (profundidad == 0) {
            // Si la profundidad es 0, dibujamos un triángulo
            int[] xPoints = {x1, x2, x3};
            int[] yPoints = {y1, y2, y3};
            g.fillPolygon(xPoints, yPoints, 3);  // Dibujar el triángulo
        } else {
            // Calcular los puntos medios de los lados del triángulo
            int xm1 = (x1 + x2) / 2;
            int ym1 = (y1 + y2) / 2;
            int xm2 = (x2 + x3) / 2;
            int ym2 = (y2 + y3) / 2;
            int xm3 = (x3 + x1) / 2;
            int ym3 = (y3 + y1) / 2;

            // Llamar recursivamente para dibujar los sub-triángulos
            dibujarTriangulo(g, x1, y1, xm1, ym1, xm3, ym3, profundidad - 1);
            dibujarTriangulo(g, xm1, ym1, x2, y2, xm2, ym2, profundidad - 1);
            dibujarTriangulo(g, xm3, ym3, xm2, ym2, x3, y3, profundidad - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Definir las coordenadas de los vértices del triángulo inicial
        int x1 = WIDTH / 2;
        int y1 = 50;
        int x2 = 50;
        int y2 = HEIGHT - 50;
        int x3 = WIDTH - 50;
        int y3 = HEIGHT - 50;

        // Llamar al método recursivo para dibujar el fractal
        g.setColor(Color.BLUE);  // Establecer el color del triángulo
        dibujarTriangulo(g, x1, y1, x2, y2, x3, y3, 6);  // 6 es la profundidad del fractal
    }

    public static void main(String[] args) {
        // Crear la ventana de JFrame
        JFrame frame = new JFrame("Fractal de Sierpinski");
        FractalSierpinski panel = new FractalSierpinski();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
