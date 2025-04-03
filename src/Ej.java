import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Ej extends JFrame{

    int ResX = 1200; // Increased width
    int ResY = 1200; // Increased height
    double XMmin, YMmin, XMmax, YMmax;
    double XNmin, YNmin, XNmax, YNmax;

    public Ej(){
        setSize(ResX, ResY);
        setVisible(true);
        setTitle("GRAFICANDO en 2D");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
    }

    public boolean enVentana(double x, double y){
        return XMmin<=x && x<=XMmax && YMmin<=y && y<=YMmax;
    }
    public void ejes(Graphics g){
        //verificar si se dibuja el eje y
        if(XMmin*XMmax<0){
            int xd1=coorXD(0);
            int yd1=coorYD(YMmax);
            int xd2=coorXD(0);
            int yd2=coorYD(YMmin);
            g.drawLine(xd1, yd1, xd2, yd2);
        }
        // verificar si se dibuja el eje x
        if(XMmin*XMmax<0){
            int xd1=coorXD(XMmin);
            int yd1=coorYD(0);
            int xd2=coorXD(XMmax);
            int yd2=coorYD(0);
            g.drawLine(xd1, yd1, xd2, yd2);
        }
    }
    public void marco (Graphics g){
        int xd1=coorXD(XMmin);
        int yd1=coorYD(YMmax);
        int xd2=coorXD(XMmax);
        int yd2=coorYD(YMmin);
        g.drawRect(xd1, yd1, xd2-xd1, yd2-yd1);
    }
    public void paint(Graphics g){
       /* ventana (-10,-5,10,5);
        mirilla(0,0,1,1);
        double x=5;
        double y=2.5;
        double xn=coorXN(x);
        double yn=coorYN(y);
        int xd=coorXD(x);
         int yd=coorYD(y);
         System.out.println("xn="+xn);
         System.out.println("xy="+yn);
         System.out.println("xd="+xd);
         System.out.println("yd="+yd);*/

        // Parábola //
        ventana(-10, -10, 10, 10);
        mirilla(0, 0, 0.333, 0.5);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        g.setColor(Color.RED);
        for (double x = -10; x <= 10; x += 0.01) {
            double y = x * x;
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        // Espiral
        ventana(-5, -5, 5, 5);
        mirilla(0.333, 0, 0.666, 0.5);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        double r = 0;
        for (double ang = 0; ang <= 5 * 10 * Math.PI; ang += 0.01) {
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.fillRect(xd, yd, 1, 1);
                r = r + 0.001;
            }
        }

        // Función seno
        ventana(-2 * Math.PI, -5, 2 * Math.PI, 5);
        mirilla(0.666, 0, 1, 0.5);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        g.setColor(Color.GREEN);
        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.01) {
            double y = 2.5 * Math.sin(x);
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        // Función de pétalos
        ventana(-10, -10, 10, 10);
        mirilla(0, 0.5, 0.333, 1);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        for (double ang = 0; ang <= 2 * Math.PI; ang += 0.01) {
            r = 8 * Math.sin(ang * 4);
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        // Función cúbica
        ventana(-10, -10, 10, 10);
        mirilla(0.333, 0.5, 0.666, 1);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        g.setColor(Color.BLUE);
        for (double ang = 0; ang <= 2 * Math.PI; ang += 0.01) {
            double a = 5; // Parámetro de la lemniscata
            double r2 = a * Math.sqrt(2 * Math.cos(2 * ang));
            double x = r2 * Math.cos(ang);
            double y = r2 * Math.sin(ang);
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        //epicicliodes (cicloides) (COORDENADAS POLARES)
        ventana(-20, -20, 20, 20);
        mirilla(0.666, 0.5, 1, 1);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        g.setColor(Color.MAGENTA);
        double R = 5, r2 = 3;
        for (double ang = 0; ang <= 2 * 10 * Math.PI; ang += 0.01) {
            double x = (R + r2) * Math.cos(ang) - r2 * Math.cos((R + r2) / r2 * ang);
            double y = (R + r2) * Math.sin(ang) - r2 * Math.sin((R + r2) / r2 * ang);
            if (enVentana(x, y)) {
                int xd = coorXD(x);
                int yd = coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }
    }



    public void ventana (double a, double b, double c,double d){
        XMmin=a;
        YMmin=b;
        XMmax=c;
        YMmax=d;

    }
    public void mirilla (double a, double b, double c,double d){
        XNmin=a;
        YNmin=b;
        XNmax=c;
        YNmax=d;
    }
    public double coorXN(double xm){
        return XNmin+(XNmax-XNmin)*(xm-XMmin)/(XMmax-XMmin) ;
    }
    public double coorYN(double ym){
        return YNmin+(YNmax-YNmin)*(YMmax-ym)/(YMmax-YMmin) ;
    }

    public int coorXD(double xm){
        return (int)(coorXN(xm)*(ResX-1));
    }
    public int coorYD(double ym){
        return (int)(coorYN(ym)*(ResY-1));
    }

    public static void main (String[]args){
        Ej p=new Ej();


    }
}