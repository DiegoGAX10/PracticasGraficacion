package Animacion3D;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import tiburcio.lib3D.*;

public class Animacion3d extends s3D {

    public Animacion3d(){
        DEF_SISTEMA("Transformaciones 3D", 600, 600, Color.black, 30, 30, 1, 300, 300);
    }

    public void paint (Graphics g){
        ejes3D(Color.white, g);
        g.setColor(Color.green);
        obj3D A = new obj3D("/home/diego-gallegos/Documents/workspace/PracticasGraficacion/src/Animacion3D/piramide.3ds");
        //dibObj3D(A, g);
        //m3D esc = new m3D();
        //esc.escalacion(0.5, 0.8, 0.25);
        m3D RFXZ = new m3D();
        m3D tras = new m3D();
        dibObj3D(A, g);
        g.setColor(Color.red);
        tras.traslacion(110, 0, 0);
        g.setColor(Color.blue);
        RFXZ.reflexionYZ();
        obj3D B = A.transforma(tras);
        dibObj3D(B, g);
        g.setColor(Color.cyan);
        dibObj3D(B.transforma(RFXZ), g);

        m3D rot = new m3D();
        for (double ang = 0;  ang <= 360; ang+= 1) {
            rot.rotacionZ(ang);
            obj3D C = B.transforma(rot);
            g.setColor(Color.red);
            dibObj3D(C, g);
            try {
                Thread.sleep(250);
            } catch (Exception e) {
            }
            g.setColor(Color.black);
            dibObj3D(C, g);
            ejes3D(Color.white, g);
        }


    }

    public static void main(String[] args) {
        Animacion3d p = new Animacion3d();

    }

}