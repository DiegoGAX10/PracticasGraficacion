package graficando3d;

import javax.swing.*;
import java.awt.*;

public class graficando3d extends JFrame {

    int resX = 600;
    int resY = 600;
    int ox = resX/2;
    int oy = resY/2;
    int A = 30;
    int B = 30;


    public graficando3d() {
        setTitle("Graficando3d");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int coorXD(double x, double y, double z) {
        double angA = A*Math.PI/180;
        double angB = B*Math.PI/180;
        return (int) (ox + x*Math.cos(angB) + z*Math.cos(angA));

    }

    public int coorYD(double x, double y, double z) {
        double angA = Math.toRadians(A);
        double angB = Math.toRadians(B);
        return (int) (oy - (y-x*Math.sin(angB)+z*Math.sin(angA)));
    }

    public void ejes3d(Graphics g) {
        int xo = coorXD(0, 0, 0);
        int yo = coorYD(0, 0, 0);
        int x1 = coorXD(1000, 0, 0);
        int y1 = coorYD(1000, 0, 0);
        int x2 = coorXD(0, 1000, 0);
        int y2 = coorYD(0, 1000, 0);
        int x3 = coorXD(0, 0, -1000);
        int y3 = coorYD(0, 0, -1000);
        g.drawLine(xo, yo, x1, y1);
        g.drawLine(xo, yo, x2, y2);
        g.drawLine(xo, yo, x3, y3);

    }

    public void punto3d(double x, double y, double z, Graphics g) {
        int xd = coorXD(x, y, z);
        int yd = coorYD(x, y, z);
        g.drawRect(xd, yd, 1, 1);
    }

    public void linea3d ( double x1, double y1, double z1, double x2, double y2, double z2, Graphics g ) {
        int xd1 = coorXD(x1, y1, z1);
        int yd1 = coorYD(x1, y1, z1);
        int xd2 = coorXD(x2, y2, z2);
        int yd2 = coorYD(x2, y2, z2);
        g.drawLine(xd1, yd1, xd2, yd2);
    }


    public void paint (Graphics g) {
        g.setColor(Color.black);
        ejes3d(g);
        //Triagnulo
        linea3d(0,200,0,200,0,0,g);
        linea3d(200,0,0,0,0,-200,g);
        linea3d(0,0,-200,0,200,0,g);
        for(double z = -100; z <= 100; z += 10)
        for (double ang = -2*Math.PI; ang <= 2*Math.PI; ang += 0.01) {
            double y = Math.abs(50*Math.sin(ang));
            punto3d(ang*50, y, 0, g);

        }
    }

    public static void main(String[] args) {
        graficando3d p = new graficando3d();
    }
}
