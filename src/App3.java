import javax.swing.*;
import java.awt.*;

public class App3 extends JFrame {
    public App3() {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setTitle("Algoritmo DDA");
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        lineaDDA(100, 100, 200, 200, g);
        g.setColor(Color.red);
        lineaDDA(200, 100, 100, 200, g);
        g.setColor(Color.green);
        lineaBres(100, 300, 200, 400, g);
        g.setColor(Color.green);
        CirculoBres(300, 300, 50, g);
    }
    public void lineaDDA(int x0, int y0, int x1, int y1, Graphics g){
        int dx = x1 - x0;
        int dy = y1 - y0;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = dx / (float) steps;
        float yIncrement = dy / (float) steps;

        float x = x0;
        float y = y0;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x),Math.round(y),1,1);
            x += xIncrement;
            y += yIncrement;
        }
    }
    private void CirculoBres(int centerX, int centerY, int radius, Graphics g) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;

        while (x <= y) {
            // Dibujar los octantes
            g.drawRect(centerX + x, centerY + y, 1, 1);
            g.drawRect(centerX - x, centerY + y, 1, 1);
            g.drawRect(centerX + x, centerY - y, 1, 1);
            g.drawRect(centerX - x, centerY - y, 1, 1);
            g.drawRect(centerX + y, centerY + x, 1, 1);
            g.drawRect(centerX - y, centerY + x, 1, 1);
            g.drawRect(centerX + y, centerY - x, 1, 1);
            g.drawRect(centerX - y, centerY - x, 1, 1);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }
    public void lineaBres(int x0,int y0, int x1, int y1, Graphics g){


        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawRect(x0,y0,1,1);
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }
    public static void main(String[] args) {
        App3 ventana = new App3();
    }
}
