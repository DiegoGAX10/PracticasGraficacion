package Curvas_Bezier;
import javax.swing.*;
import java.awt.*;

public class Bezier extends JFrame {
    double[][] puntosDeControl = {
            {1,1},
            {4,7},
            {7,-4},
            {10,2}
    };

    public Bezier() {
        setTitle("Curva de Bezier");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        BezierTab BezierTab = new BezierTab();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        drawBezier(g);
    }

    public void drawBezier(Graphics g){
        double t;
        int centroX = 300;
        int centroY = 300;
        int escala=50;
        int xAnt=(int)(puntosDeControl[0][0] *escala +centroX);
        int yAnt=(int)(puntosDeControl[0][1] *escala +centroY);

        for (int i =0;i <= 1000; i++){
            t=i/1000.0; //incremento de 0.001
            int x=(int)((Math.pow(1-t,3)*puntosDeControl[0][0] +
                    3*Math.pow(1-t,2)*t*puntosDeControl[1][0] +
                    3*(1-t)*Math.pow(t,2)*puntosDeControl[2][0]+
                    Math.pow(t,3)*puntosDeControl[3][0])*escala +centroX);

            int y=(int)((Math.pow(1-t,3)*puntosDeControl[0][1]+
                    3*Math.pow(1 - t, 2)*t*puntosDeControl[1][1]+
                    3*(1 - t)*Math.pow(t, 2)*puntosDeControl[2][1]+
                    Math.pow(t,3)*puntosDeControl[3][1])*escala +centroY);

            g.drawLine(xAnt,yAnt,x,y);
            xAnt=x;
            yAnt=y;
        }
        g.setColor(Color.RED);
        for (int i=0;i<4;i++){
            g.fillOval((int)(puntosDeControl[i][0]*50+300)-5,
                    (int)(puntosDeControl[i][1]*50+300)-5,10,10);
        }
    }

    public static void main(String[] args) {
        new Bezier();
    }
}
