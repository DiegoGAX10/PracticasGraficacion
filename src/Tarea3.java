import javax.swing.*;
import java.awt.*;

public class Tarea3 extends JFrame {
    public Tarea3() {
        setSize(600, 600);
        setUndecorated(false);
        setVisible(true);
        setTitle("Fractalito");
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {
       //fractalito(300,300,50,g);
        int nl = 5;
        double ang =0;
        double inc=(Math.PI*2)/nl;
        double radio=200;
        for(int i=1; i<=nl;i++){
            double x=300+radio*Math.cos(ang);
            double y=300-radio*Math.sin(ang);
            g.setColor(Color.red);
            CirculoBres((int) x,(int) y,5,g);
            ang+=inc;
        }
        for(int i=0; i<nl;i++){
            double x1=300+radio*Math.cos(i*inc);
            double y1=300-radio*Math.sin(i*inc);
            double x2=300+radio*Math.cos((i+1)*inc);
            double y2=300-radio*Math.sin((i+1)*inc);
            lineaDDA((int) x1,(int) y1,(int) x2,(int) y2,g);
        }
        radio /= 2;
        ang = 0;
        for (int i = 1; i <= nl; i++) {
            double x = 300 + radio * Math.cos(ang);
            double y = 300 - radio * Math.sin(ang);
            g.setColor(Color.blue);
            CirculoBres((int) x, (int) y, 5, g);
            ang += inc;
        }
        for (int i = 0; i < nl; i++) {
            double x1 = 300 + radio * Math.cos(i * inc);
            double y1 = 300 - radio * Math.sin(i * inc);
            double x2 = 300 + radio * Math.cos((i + 1) * inc);
            double y2 = 300 - radio * Math.sin((i + 1) * inc);
            lineaDDA((int) x1, (int) y1, (int) x2, (int) y2, g);
        }

    }

    public void fractalito(int xc, int yc, int radio, Graphics g){
        CirculoBres(xc,yc,radio,g);
        if (radio > 5){
            fractalito(xc+3*radio/2,yc,radio/2,g);
            fractalito(xc-3*radio/2,yc,radio/2,g);
            fractalito(xc,yc+radio,radio/2,g);
            fractalito(xc,yc-radio,radio/2,g);
        }
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
                Thread.sleep(1);
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
        Tarea3 ventana = new Tarea3();
    }
}
