import tiburcio.lib2D.*;
import java.awt.Color;
import java.awt.Graphics;

public class Dibujando2d2 extends s2D{

    public Dibujando2d2() {
        DEF_SISTEMA("ANIMACIONES DE PUNTO FIJO", 600, 600, Color.BLACK);

    }

    public void paint (Graphics g) {
        MIRILLA(0, 0, 1, 1);
        VENTANA(-10, -10, 10, 10);
        g.setColor(Color.green);
        ejes(g);
        obj2D A = new obj2D("/home/diego-gallegos/Documents/Trapecio.2d");
        dibObj2D(A, g);
        //traslacion
        m2D MT = new m2D();
        MT.traslacion(-1, -3);
        m2D MT2 = new m2D();
        MT2.traslacion(1, 3);
        //escalacion
        m2D MR = new m2D();
        m2D MTC = new m2D();
        for (double a = 5; a>=0.1; a -= 0.1) {
            MR.escalacion(a, a);
            MTC = MT.multiplica(MR).multiplica(MT2);
            obj2D B = A.transforma(MTC);
            g.setColor(Color.GREEN);
            dibObj2D(B, g);
            try {
                Thread.sleep(500);
            } catch (Exception EX) {
            }
            g.setColor(Color.black);
            dibObj2D(B, g);
            g.setColor(Color.green);
            ejes(g);
        /*
        //rotacion
        m2D MR = new m2D();
        m2D MTC = new m2D();
        for (double ang = 0; ang <= 360; ang += 10){
            MR.rotacion(ang);
            MTC = MT.multiplica(MR).multiplica(MT2);
            obj2D B = A.transforma(MTC);
            g.setColor(Color.GREEN);
            dibObj2D(B, g);
            try{
                Thread.sleep(500);
            }catch(Exception EX){}
            g.setColor(Color.black);
            dibObj2D(B, g);
            g.setColor(Color.green);
            ejes(g);
        }

         */
        }
    }


    public static void main(String[] args) {
        Dibujando2d2 p = new Dibujando2d2();
    }
}
