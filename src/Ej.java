import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Ej extends JFrame{

    int ResX=600,ResY=600;
    double XMmin,YMmin,XMmax,YMmax;
    double XNmin,YNmin,XNmax,YNmax;

    public Ej(){
        setSize(ResX,ResY);
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

        /*
        ventana(-5,-5,10,10);
        mirilla(0.1,0.1,0.9,0.9);
        g.setColor(Color.BLACK);
        marco(g);
        g.setColor(Color.red);
        ejes(g);
        g.setColor(Color.green);
        for(double x=-10;x<=10;x+=0.01){
            double y=x*x;
            if(enVentana(x,y)){
                int xd=coorXD(x);
                int yd=coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }
         */

        /* Hacer ondas por 3 PI
        ventana(-2*Math.PI,-5,2*Math.PI,5);
        mirilla(0,0,1,1);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        g.setColor(Color.RED);
        for (double x=-2*Math.PI;x<=2*Math.PI;x+=0.01){
            double y=(2.5*Math.sin(x));
            if(enVentana(x,y)){
                int xd=coorXD(x);
                int yd=coorYD(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }
         */
        ventana(-10,-10,10,10);
        mirilla(0,0,1,1);
        g.setColor(Color.WHITE);
        ejes(g);
        marco(g);
        double r=0 ;
        for (double ang=0;ang<=2*10*Math.PI;ang+=0.01){
            double x=r*Math.cos(ang);
            double y=r*Math.sin(ang);
            if(enVentana(x,y)){
                int xd=coorXD(x);
                int yd=coorYD(y);
                g.drawRect(xd, yd, 1, 1);
                r=r+0.001;
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