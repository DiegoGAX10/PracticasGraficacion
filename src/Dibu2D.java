import java.awt.Color;
import java.awt.Graphics;
import tiburcio.lib2D.*;

public class Dibu2D extends s2D {

    public Dibu2D() {
        DEF_SISTEMA("Transformaciones 2D", 600, 600, Color.yellow);
    }

    public void paint(Graphics g) {
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
        obj2D A = new obj2D("/home/diego-gallegos/Documents/figuraA.D2");
        dibObj2D(A, g);
        obj2D B = A.transforma(MTCab);
        g.setColor(Color.red);
        dibObj2D(B, g);
        g.setColor(Color.magenta);
        m2D MR = new m2D();
        for (double ang = 0; ang <= 360; ang += 15)
        {
            MR.rotacion(ang);
        obj2D C = B.transforma(MR);
        dibObj2D(C, g);
            try{
                Thread.sleep(500);
            }catch(Exception EX){}
            g.setColor(Color.black);
            dibObj2D(C,g);
        }
        /*
        v2D va  = new v2D(2, 1);
        v2D vb = new v2D(5, 1);
        v2D vc = new v2D(5, 3);
        v2D vd = new v2D(2, 4);

        v2D vat = va.multiplica(MTCab);
        v2D vbt = vb.multiplica(MTCab);
        v2D vct = vc.multiplica(MTCab);
        v2D vdt = vd.multiplica(MTCab);

        vat.imprime();
        vbt.imprime();
        vct.imprime();
        vdt.imprime();
*/

        //Diseñar un objeto con contornos, no repetido  en 2D (carro) con extencion .2d. Dibujarlo. Despues moverlo (transformaciones)( 4 (escalacion, traslacion, rotacion, reflexion) y dibujarlo.

    }

    public static void main(String[] args) {
        Dibu2D p = new Dibu2D();
    }
}