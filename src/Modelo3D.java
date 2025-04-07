import tiburcio.lib3D.m3D;
import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

import java.awt.*;

public class Modelo3D extends s3D {

    public Modelo3D() {
        DEF_SISTEMA("Modelo3D", 600, 600, Color.BLACK,30,30,1,300,300);

    }

    public void paint(Graphics g){
    ejes3D(Color.green,g);
    obj3D tetera = new obj3D("tetera.obj"); //aqui va la arista que sacamos de asc
    m3D r = new m3D();
    //e.escalacion(100,250,100);
        //dibObj3D(tetera.transforma(e),g);
    for (double ang=0;ang<360;ang+=15){
        r.rotacionY(ang);
        dibObj3D(tetera.transforma(r),g);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            g.setColor(Color.BLACK);
            dibObj3D(tetera.transforma(r),g);
        }
    }
}

//hacer la animacion que hicimos en 2d pero ahora en 3d

    public static void main(String[] args) {
        new Modelo3D();
    }
}
