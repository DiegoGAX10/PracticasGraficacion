package Animacion3D;

import java.awt.Color;
import java.awt.Graphics;
import tiburcio.lib3D.m3D;
import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

public class Animacion3d extends s3D {
    public Animacion3d() {
        DEF_SISTEMA("Animación 3D", 600, 600, Color.black, 30, 30, 1, 300, 300);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        ejes3D(Color.white, g);
        obj3D A = new obj3D("./src/Animacion3D/cubo.3d");
        g.setColor(Color.green);
        dibObj3D(A, g);

        // Escalación del 100% al 200%
        for (double factor = 1.0; factor <= 2.0; factor += 0.05) {
            m3D T1 = new m3D(); T1.traslacion(-100, 0, 100);
            m3D S  = new m3D(); S.escalacion(factor, factor, factor);
            m3D T2 = new m3D(); T2.traslacion(100, 0, -100);
            m3D transformacion = T1.multiplica(S).multiplica(T2);
            obj3D J = A.transforma(transformacion);

            g.setColor(Color.red);
            dibObj3D(J, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(J, g);
            ejes3D(Color.green, g);
        }

        // Escalación del 300% al 100%
        for (double factor = 3.0; factor >= 1.0; factor -= 0.05) {
            m3D T1 = new m3D(); T1.traslacion(-100, 0, 100);
            m3D S  = new m3D(); S.escalacion(factor, factor, factor);
            m3D T2 = new m3D(); T2.traslacion(100, 0, -100);
            m3D transformacion = T1.multiplica(S).multiplica(T2);
            obj3D J = A.transforma(transformacion);

            g.setColor(Color.red);
            dibObj3D(J, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(J, g);
            ejes3D(Color.green, g);
        }

        // Rotación en el eje Y
        for (double angY = 0; angY <= 360; angY += 5) {
            m3D rotY = new m3D();
            rotY.rotacionY(angY);
            obj3D B = A.transforma(rotY);

            g.setColor(Color.red);
            dibObj3D(B, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(B, g);
            ejes3D(Color.green, g);
        }

        // Traslación en Y y Z
        for (double dy = 0; dy <= 100; dy += 2) {
            m3D traslacion = new m3D();
            traslacion.traslacion(dy, 0, dy);
            obj3D J = A.transforma(traslacion);
            g.setColor(Color.red);
            dibObj3D(J, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(J, g);
            ejes3D(Color.green, g);
        }

        // Rotación en el eje X
        for (double angX = 0; angX <= 360; angX += 5) {
            m3D rotX = new m3D();
            rotX.rotacionX(angX);
            obj3D B = A.transforma(rotX);

            g.setColor(Color.red);
            dibObj3D(B, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(B, g);
            ejes3D(Color.green, g);
        }

        // Rotación en el eje Z
        for (double angZ = 0; angZ <= 360; angZ += 5) {
            m3D rotZ = new m3D();
            rotZ.rotacionZ(angZ);
            obj3D B = A.transforma(rotZ);

            g.setColor(Color.red);
            dibObj3D(B, g);

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // Ignoramos
            }

            g.setColor(Color.black);
            dibObj3D(B, g);
            ejes3D(Color.green, g);
        }

        // Reflexión en Z
        m3D reflejo = new m3D();
        reflejo.reflexionXZ();
        obj3D J = A.transforma(reflejo);

        g.setColor(Color.red);
        dibObj3D(J, g);

        g.setColor(Color.red);
        dibObj3D(A, g);
    }

    public static void main(String[] args) {
        new Animacion3d();
    }
}