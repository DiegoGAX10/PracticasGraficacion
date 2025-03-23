import java.awt.Color;
import java.awt.Graphics;
import tiburcio.lib2D.*;

public class Dibujando2D extends s2D {

    public Dibujando2D() {
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
        //*
        v2D va  = new v2D(1, 1);
        v2D vb = new v2D(4, 1);
        v2D vc = new v2D(3, 3);
        v2D vd = new v2D(1, 1);

        v2D vap = va.multiplica(MTCab);
        v2D vbp = vb.multiplica(MTCab);
        v2D vcp = vc.multiplica(MTCab);
        v2D vdp = vd.multiplica(MTCab);

        vap.imprime();
        vbp.imprime();
        vcp.imprime();
        vdp.imprime();
        VENTANA(-10, -10, 10, 10);
        MIRILLA(0, 0, 1, 1);
        g.setColor(Color.BLACK);
        ejes(g);
        obj2D A = new obj2D("/home/diego-gallegos/Documents/figuraA.txt");
        dibObj2D(A, g);

        obj2D B = A.transforma(MTCab);
        dibObj2D(B, g);

        m2D MRot = new m2D();
        for (double ang = 0; ang <= 360; ang += 15)
        {
            MRot.rotacion(ang);
            obj2D c = A.transforma(MRot);
            g.setColor(Color.green);
            dibObj2D(c, g);
            try{
                Thread.sleep(500);
            }catch(Exception E){}
            g.setColor(Color.black);
            dibObj2D(c,g);
        }
    }

    public static void main(String[] args) {
        Dibujando2D p = new Dibujando2D();
    }
}