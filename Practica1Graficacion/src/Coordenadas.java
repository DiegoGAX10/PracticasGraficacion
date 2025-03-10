import javax.swing.*;
import java.awt.*;

public class Coordenadas extends JFrame {

    int resX = 600;
    int resY = 600;
    double XMmin, XMmax, YMmin, YMmax;
    double XNmin, YNmin, XNmax, YNmax;


    public Coordenadas(){
        setTitle("Graficando en 2d");
        setSize(resX, resY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void paint(Graphics g){
       /* VENTANA(-10,-5,10,5);
        MIRILLA(0,0,1,1);
        double x = 10;
        double y = 2.5;
        double xn = CoorXN(x);
        double yn = CoorYN(y);
        int xd = (int) CoorXD(x);
        int yd = (int) CoorYD(y);
        System.out.println("xn=" +xn);
        System.out.println("yn=" +yn);
        System.out.println("xd=" +xd);
        System.out.println("yd=" +yd);
        */
        VENTANA(-10,10,-1,1);
        MIRILLA(0,0,0.5,.5);
        for(double x=-10; x<=10; x+=0.1){
            double y = Math.sin(x);
            int xd = (int) CoorXD(x);
            int yd = (int) CoorYD(y);
            g.setColor(Color.red);
            g.fillRect(xd,yd,1,1);
        }
    }

    public void VENTANA (double a, double b, double c, double d) {
        XMmin = a;
        XMmax = b;
        YMmin = c;
        YMmax = d;
    }

    public void MIRILLA(double a, double b, double c, double d){
        XNmin = a;
        YNmin = b;
        XNmax = c;
        YNmax = d;
    }
    public double CoorXN(double X){
        return XNmin+(XNmax-XMmin)*((X-XMmin)/(XMmax-XMmin));
    }
    public double CoorYN(double Y){
        return YNmin+(YNmax-YMmin)*((Y-YMmin)/(YMmax-YMmin));
    }
    public double CoorXD(double X){
        return (int) (CoorXN(X)*(resX-1));
    }
    public double CoorYD(double Y){
        return (int) (CoorYN(Y)*(resY-1));
    }
    

    public static void main(String[] args) {
        new Coordenadas();
    }

}
