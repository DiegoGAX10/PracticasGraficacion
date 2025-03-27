package Dibujando;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import tiburcio.lib2D.*;

public class casa2d extends s2D {

    private final List<obj2D> objetos = new ArrayList<>();

    public casa2d() {
        DEF_SISTEMA("Transformaciones 2D", 600, 600, Color.yellow);
        cargarObjetos();
    }

    private void cargarObjetos() {
        objetos.add(new obj2D("/home/diego-gallegos/Documents/workspace/PracticasGraficacion/src/2d/casa.2d"));
    }

    public void paint(Graphics g) {
        MIRILLA(0, 0, 1, 1);
        VENTANA(-25, -25, 25, 25);
        g.setColor(Color.black);
        ejes(g);
        g.setColor(Color.green);
        for (obj2D obj : objetos) {
            dibObj2D(obj, g);
        }

        // Escalacion en un bucle
        m2D mt1 = new m2D();
        m2D mt2 = new m2D();
        m2D mEscal = new m2D();
        m2D MTC;
        mt1.traslacion(-1, -1);
        mt2.traslacion(1, 1);
        for (double ang = 1; ang >= 0.1; ang -= 0.05) {
            mEscal.escalacion(ang, ang);
            MTC = mt1.multiplica(mEscal).multiplica(mt2);
            List<obj2D> objetosEscalados = new ArrayList<>();
            for (obj2D obj : objetos) {
                objetosEscalados.add(obj.transforma(MTC));
            }
            g.setColor(Color.green);
            for (obj2D obj : objetosEscalados) {
                dibObj2D(obj, g);
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            for (obj2D obj : objetosEscalados) {
                dibObj2D(obj, g);
            }
        }

        // Traslación en un bucle
        m2D Mtran = new m2D();
        for (double ang = 0; ang <= 10; ang++) {
            double dx = ang;
            Mtran.traslacion(dx, 0);
            List<obj2D> objetosTrans = new ArrayList<>();
            for (obj2D obj : objetos) {
                objetosTrans.add(obj.transforma(Mtran));
            }
            g.setColor(Color.green);
            for (obj2D obj : objetosTrans) {
                dibObj2D(obj, g);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            for (obj2D obj : objetosTrans) {
                dibObj2D(obj, g);
            }
        }

        // Traslación final
        m2D TransFn = new m2D();
        TransFn.traslacion(15, 0);
        // Rotación en un bucle
        m2D MRot = new m2D();
        for (double ang = 0; ang <= 360; ang += 45) {
            MRot.rotacion(ang);
            List<obj2D> objetosRotados = new ArrayList<>();
            for (obj2D obj : objetos) {
                objetosRotados.add(obj.transforma(MRot));
            }
            g.setColor(Color.yellow);
            for (obj2D obj : objetosRotados) {
                dibObj2D(obj, g);
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            for (obj2D obj : objetosRotados) {
                dibObj2D(obj, g);
            }
        }

        // Transformación de reflexión
        m2D MRef = new m2D();
        MRef.reflexionY();
        obj2D B = objetos.get(0);
        obj2D D = B.transforma(MRef);
        g.setColor(Color.green);
        dibObj2D(D, g);
    }

    public static void main(String[] args) {
        new casa2d();
    }
}