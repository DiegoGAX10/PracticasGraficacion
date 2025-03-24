package Dibujando;

import java.awt.Color;
import java.awt.Graphics;
import tiburcio.lib2D.*;

public class casa2d extends s2D {

    public casa2d() {
        DEF_SISTEMA("Transformaciones 2D", 600, 600, Color.yellow);
    }

    public void paint(Graphics g) {
        //moverlo (transformaciones)( 4 (escalacion, traslacion, rotacion y reflexion)
        m2D MT1 = new m2D();
        m2D ME = new m2D();
        m2D MT2 = new m2D();
        m2D MTCab = new m2D();
        MT1.traslacion(-2, -1);
        MT1.imprime();
        ME.escalacion(2, 1);
        ME.imprime();
        MT2.traslacion(0, -5);
        MT2.imprime();
        MTCab = MT1.multiplica(ME).multiplica(MT2);
        MTCab.imprime();
        VENTANA(-10, -10, 10, 10);
        MIRILLA(0, 0, 1, 1);
        g.setColor(Color.BLACK);
        ejes(g);
        g.setColor(Color.blue);
        obj2D A = new obj2D("/home/diego-gallegos/Documents/casa.2d");
        dibObj2D(A, g);
        obj2D B = A.transforma(MTCab);
        g.setColor(Color.red);
        dibObj2D(B, g);
        g.setColor(Color.magenta);
        //rotacion
        m2D MR = new m2D();
        for (double ang = 0; ang <= 360; ang += 30) {
            MR.rotacion(ang);
            obj2D C = B.transforma(MR);
            dibObj2D(C, g);
            try {
                Thread.sleep(500);
            } catch (Exception EX) {}
            g.setColor(Color.BLACK);
            dibObj2D(C, g);
        }
        //reflexion
        m2D MRef = new m2D();
        MRef.reflexionY();
        obj2D D = B.transforma(MRef);
        g.setColor(Color.green);
        dibObj2D(D, g);
    }

    public static void main(String[] args) {
        casa2d p = new casa2d();
    }
}

//preguntas, convertir de a a b i